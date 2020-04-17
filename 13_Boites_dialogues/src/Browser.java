import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.StringTokenizer;
import java.applet.*;
import java.awt.*;

public class Browser extends Applet implements ActionListener {

	TextField info, error;
	List liste;
	TextArea contenu;
	File f;
	Image img = null;

	String path;

	public void init() {
		setSize(600, 300);
		setLayout(new BorderLayout());
		info = new TextField(10);
		error = new TextField(10);
		liste = new List();
		contenu = new TextArea();
		// contenu.setVisible(false);
		liste.addActionListener(this);

		add(BorderLayout.NORTH, info);
		add(BorderLayout.SOUTH, error);
		add(BorderLayout.WEST, liste);
		add(BorderLayout.CENTER, contenu);
		path = ".";
		liste_update(path);
		//contenu.setBackground(arg0);

	}

	public void liste_update(String str) {
		try {
			liste.removeAll();
			liste.addItem(".");
			liste.addItem("..");
			f = new File(str);

			for (int i = 0; i < f.list().length; i++) {
				liste.addItem(f.list()[i]);
			}
		}

		catch (Exception e) {
			error.setText(e.toString());
		}
	}

	public boolean isFile(String str) {
		boolean flag = false;
		f = new File(str);
		flag = f.isFile();
		return flag;
	}

	public String getPath(String str) {
		String path = "";
		f = new File(str);
		path = f.getAbsolutePath();
		return path;
	}

	public int getSize(String str) {
		int val = 0;
		f = new File(str);
		val = (int) f.length();
		return val;
	}

	public Boolean isImage(String str) {
		Boolean flag = false;
		
		String chaine = str.substring(str.length()-3,  str.length());
		System.out.println("Image "+chaine);
		
		if (chaine.contains("gif") || chaine.contains("jpg") || chaine.contains("png")) {
			flag = true;
			System.out.println("Pass");
		}
		return flag;
	}

	public void affImage(String str) {
		img = getImage(getCodeBase(), str);
		repaint();
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 100, 100, getSize().width/2, getSize().height/2, this);
	}

	public void afficheContenu(String str) {

		try {
			contenu.setText("");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
			String ligne;

			while ((ligne = br.readLine()) != null) {
				contenu.append(ligne + "\n");
			}
			br.close();
		}

		catch (Exception e) {
			error.setText(e.toString());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = liste.getSelectedItem();
		String new_str = path + "/" + str;

		if (isFile(new_str)) {

			if (isImage(new_str)) {
				
				contenu.setVisible(false);
				
				affImage(new_str);
				
			} else {
				contenu.setVisible(true);
				info.setText(getPath(new_str));
				error.setText("Taille de fichier :" + getSize(new_str) + " octets");
				afficheContenu(new_str);

			}
		} else {
			path = path + "/" + str;
			liste_update(path);
			System.out.println(path);
		}

	}

}