
import java.awt.event.*;
import java.io.*;
import java.applet.*;
import java.awt.*;

public class BrowserApplet extends Applet implements ItemListener {

	TextField info, error;
	List liste;
	TextArea contenu;
	File f;
	Image img = null;
	LoadImage LI = null;
	String path;
	CardLayout carte;							// CardLayout pour alterner l'afficahe de l'image et du texte 
	Panel text_Images;

	public void init() {
		setSize(600, 300);
		carte = new CardLayout();
		setLayout(new BorderLayout());
		info = new TextField(10);
		error = new TextField(10);
		liste = new List();
		contenu = new TextArea();
		liste.addItemListener(this);
		add(BorderLayout.NORTH, info);
		add(BorderLayout.SOUTH, error);
		add(BorderLayout.WEST, liste);
		text_Images = new Panel();      		// Panel pour l'image et la zone de texte
		text_Images.setLayout(carte);
		text_Images.add("Text", contenu); 		// Placement de la zone de texte en première position
		add("Center", text_Images);				// Placement du panel au centre de la fenêtre
		path = ".";
		liste_update(path);
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

	public String getPath(String str) {
		String path = "";
		f = new File(str);
		//path = f.getAbsolutePath();
		try
		{
			path = f.getCanonicalPath();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return path;
	}

	public int getSize(String str) {
		int val = 0;
		f = new File(str);
		val = (int) f.length();
		return val;
	}

	public boolean isFile(String str) {
		boolean flag = false;
		f = new File(str);
		flag = f.isFile();
		return flag;
	}

	public Boolean isImage(String str) {
		Boolean flag = false;

		if (str.endsWith("gif") || str.endsWith("jpg") || str.endsWith("png")) {

			flag = true;
			// System.out.println("Pass");
		}
		return flag;
	}

	public Boolean isTextFile(String str) {
		Boolean flag = false;

		if (str.endsWith("txt") || str.endsWith("java")) {
			flag = true;
			// System.out.println("Pass");
		}
		return flag;
	}

	public void affImage(String str) {
		if (LI != null) {
			text_Images.remove(LI);					// Suppression de l'ancienne image si elle existe 
		}

		LI = new LoadImage(str);					// Création d'une nouvelle image
		text_Images.add(LI);
		// img = getImage(getCodeBase(), str);
		// repaint();
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String str = liste.getSelectedItem();
		String new_str = path + "/" + str;
		info.setText(getPath(new_str));

		if (isFile(new_str)) {

			if (isImage(new_str)) {
				//System.out.println("Image : " + new_str);
				affImage(new_str);
				carte.last(text_Images);					// Affichage du dernier objet du panel ( image)

			} else {
				if (isTextFile(new_str)) {
					contenu.setVisible(true);
					// info.setText(getPath(new_str));
					error.setText("Taille de fichier :" + getSize(new_str) + " octets");
					afficheContenu(new_str);
				}

			}
		} else {
			path = path + "/" + str;
			liste_update(path);
			//System.out.println(path);
		}

	}

}