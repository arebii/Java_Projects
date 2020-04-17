import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class CliFTP extends Frame implements ItemListener, ActionListener {

	TextField host, port;
	TextField inf_err;
	TextField chemin;

	Button connect;
	List liste;
	TextArea contenu;

	PrintWriter pr;
	FileDialog fDial;

	Socket sk;
	BufferedReader depuisServeur;
	PrintWriter versServeur;

	public CliFTP() {
		setSize(600, 300);
		setTitle(" Client FTP");
		setLayout(new BorderLayout());

		fDial = new FileDialog(this, "Choisir", FileDialog.SAVE);

		MenuItem mi;

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		mi = new MenuItem("Save");
		mi.addActionListener(this);
		m1.add(mi);
		mi = new MenuItem("Save as");
		mi.addActionListener(this);
		m1.add(mi);
		m1.addSeparator();
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);

		host = new TextField(10);
		host.setText("localhost");
		port = new TextField(10);
		port.setText("1235");
		connect = new Button("Connect");
		connect.addActionListener(this);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 5));
		p1.add(new Label("Host"));
		p1.add(host);
		p1.add(new Label("Port"));
		p1.add(port);
		p1.add(connect);

		chemin = new TextField(10);

		Panel nord = new Panel();
		nord.setLayout(new GridLayout(2, 1));
		nord.add(p1);
		nord.add(chemin);

		add(BorderLayout.NORTH, nord);

		inf_err = new TextField(10);
		add(BorderLayout.SOUTH, inf_err);

		liste = new List();
		contenu = new TextArea();
		liste.addItemListener(this);
		add(BorderLayout.WEST, liste);
		add(BorderLayout.CENTER, contenu);
		addWindowListener(new Fermeture());

	}

	public void Connect() {
		try {

			int n_port = Integer.parseInt(port.getText());
			sk = new Socket(host.getText(), n_port);
			depuisServeur = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			versServeur = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
			inf_err.setText("Connexion établie avec le serveur " + host.getText() + " ...");
		} catch (Exception e) {
			inf_err.setText(e.toString());
		}

	}

	public void Disconnect() {
		try {
			sk.close();
			inf_err.setText("Connexion terminée avec le serveur " + host.getText() + " ...");
		} catch (IOException e) {
		}
	}

	public void sendToServer(String command) {
		versServeur.println(command);
	}

	public void readFromServer() {

		String ligne = "";
		try {
			liste.removeAll(); // Efface ce qu'il y a avant
			liste.addItem(".");
			liste.addItem("..");
			ligne = depuisServeur.readLine(); // Première lecture du serveur
			do {
				if (ligne.indexOf('.') > 1) // Est ce un fichier ? format XXX.xxx

				{
					if (ligne.endsWith(".txt") || ligne.endsWith(".java") || ligne.endsWith(".xml")) {
						liste.addItem(ligne);
					}
				}

				else {
					liste.addItem(ligne);
				}

				// Remplire la liste jusqu'à EOF
				ligne = depuisServeur.readLine();
			} while (!(ligne.startsWith("EOF")));
		} catch (Exception e) {
			inf_err.setText(e.toString());
		}
	}

	public void readFromServFile() {
		contenu.setText("entre dans lecture fichier");
		String line;
		String content = "";
		try {
			line = depuisServeur.readLine();
			do {
				content += (line + "\n");
				line = depuisServeur.readLine();
			} while (!line.startsWith("EOF"));
			contenu.setText(content);
		} catch (Exception exp) {
			exp.toString();
		}
	}

	public boolean isFile() {
		boolean flag = false;
		String ligne;
		try {
			ligne = depuisServeur.readLine();
			if (ligne.startsWith("isFile")) {
				flag = true;
			}
		} catch (Exception e) {
			inf_err.setText(e.toString());
		}

		return flag;
	}

	public void readPwd(boolean b, String str) {
		try {
			sendToServer("pwd");
			if (b == true) {
				chemin.setText(depuisServeur.readLine() + "\\" + str);
			} else {
				chemin.setText(depuisServeur.readLine());
			}
		} catch (IOException e) {
		}
	}

	public void saveText(String fic) {
		try {
			if (fic.length() != 0) {
				pr = new PrintWriter(new FileOutputStream(fic));
				String st = contenu.getText();
				if (st.length() != 0) {
					pr.write(contenu.getText());
					inf_err.setText("Sauvegarde effectuée");
				}
				pr.close();
			} else {
				inf_err.setText("Aucun fichier selectionné");
			}
		} catch (IOException e) {
			inf_err.setText(e.toString());
		}
	}

	public void saveAs() {
		String fichier = "";
		fDial.setVisible(true);
		fichier = fDial.getDirectory() + "/" + fDial.getFile();
		saveText(fichier);
	}

	public static void main(String args[]) {
		CliFTP cfp = new CliFTP();
		cfp.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		sendToServer("check " + liste.getSelectedItem());
		if (isFile() == true) {
			System.out.println(liste.getSelectedItem() + " est un fichier");
			sendToServer("get " + liste.getSelectedItem());
			readFromServFile();

			readPwd(true, liste.getSelectedItem());

		} else {
			System.out.println(liste.getSelectedItem() + " est un répertoire");
			sendToServer("cd " + liste.getSelectedItem());
			readFromServer();

			readPwd(false, "");

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = "";
		if (e.getActionCommand().equals("Connect")) {
			Connect(); // connection au seveur

			sendToServer("dir"); // envoi de la commande dir
			readFromServer();
			System.out.println("Liste Update...");

			str = "Disconnect";
			connect.setLabel(str);
			connect.setActionCommand(str);

		} else if (e.getActionCommand().equals("Disconnect")) {
			Disconnect();
			str = "Connect";
			connect.setLabel(str);
			connect.setActionCommand(str);
		} else if (e.getActionCommand().equals("Save as")) {

			saveAs();
		} else if (e.getActionCommand().equals("Save")) {

			Boolean rep = MsgBox.affQuest(this,
					"Vous êtes sur le point de sauvegarder un fichier, voulez vous continuer?");
			if (rep == true) {
				saveText("./" + liste.getSelectedItem());
			}
		}

	}

}