import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.*;
import java.util.StringTokenizer;

@SuppressWarnings("deprecation")
public class Visionneur extends Applet implements ActionListener {
	Image img;
	List choix;
	String directory = "../../Images/"; // Chemin relatif des images à partir du repértoire bin du projet Flots_Octets
										// dans mon cas les images sont dans le répertoire D:/Projets/Projets_Java/Images 
	URL url ;
	public void init() {
		setSize(600, 600);
		setLayout(new BorderLayout());
		// addWindowListener(new Fermeture());
		choix = new List();
		add("West", choix);
		choix.addActionListener(this);
		dir(directory);
		url = getCodeBase(); 	
	}
	/*
	 * public static void main(String [] args) { Affiche_image af = new
	 * Affiche_image(); af.setVisible(true); }
	 */

	public void dir(String name) {
		File f = new File(name);
		System.out.println(f.getAbsolutePath());
		String[] liste = f.list();

		for (int i = 0; i < liste.length; i++) {
			System.out.println(liste[i]);
			if (isImage(liste[i])) {
				choix.addItem(liste[i]);
			}
		}
	}

	public Boolean isImage(String str) {
		Boolean flag = false;
		StringTokenizer st = new StringTokenizer(str, ".", false);
		// System.out.println(st.nextToken());
		st.nextToken();
		String token = st.nextToken();
		if (token.contains("gif") || token.contains("jpg") || token.contains("png")) {
			flag = true;
			System.out.println("Pass");
		}
		return flag;
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 100, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		img = getImage(url, directory+choix.getSelectedItem());
		repaint();

	}
}