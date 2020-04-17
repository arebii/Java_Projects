import java.awt.*;
import java.awt.event.*;

public class ChoixFichiers extends Frame implements ActionListener {
	
	TextArea zoneTexte = new TextArea();
	FileDialog fDial;

	public ChoixFichiers() {
		
		//super("Sélection de fichiers");
		
		fDial = new FileDialog(this, "Choisir", FileDialog.LOAD);
// Définition et affichage du système de menus
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		MenuItem mi1 = new MenuItem("Sélection...");
		mi1.setActionCommand("select");
		m1.add(mi1);
		mi1.addActionListener(this);
		MenuItem mi2 = new MenuItem("Quitter");
		mi2.setActionCommand("quitter");
		m1.add(mi2);
		mi2.addActionListener(this);
//zone texte
		add(BorderLayout.CENTER, zoneTexte);
		zoneTexte.setEditable(false);
//fermeture de la fenêtre
		addWindowListener(new Fermeture());
//taille et position
		pack();
		setBounds(50, 50, 300, 400);
//affichage
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("quitter"))
			System.exit(0);
		else if (e.getActionCommand().equals("select")) {
			fDial.setVisible(true);
			String nom = fDial.getFile();
			if (nom != null) {
				String dir = fDial.getDirectory();
				zoneTexte.append(dir + nom + "\n");
			} else
				zoneTexte.append("Sélection annulée.\n");
		}
	}

	public static void main(String args[]) {
		System.out.println("Ouverture de l'application...");
		ChoixFichiers fr = new ChoixFichiers();
	}

	/**
	 * Gestion de l'événement Case de fermeture
	 */
	class Fermeture extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			System.exit(0);
		}
	}
}