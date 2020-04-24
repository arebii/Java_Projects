/**
 * Exemple d'application swing
 */

//importation du package swing
import javax.swing.*; //nom final du package
//import com.sun.java.swing.*; //utilisé par JDK 1.1 et swing.jar
import java.awt.*;
import java.awt.event.*;

/**
 * classe principale : elle contient une méthode createComponents qui renvoie un
 * JPanel à insérer dans une fenêtre
 */

public class SwingApplication {

	JFrame fen; // fenêtre de l'application
	JButton changeLAF; // bouton changement de style
	UIManager.LookAndFeelInfo laf[]; // styles disponibles
	int lafNo = 0; // numéro style courant
	JLabel nomStyle; // nom du style utilisé

	public SwingApplication() {
		// chargement des styles disponibles
		laf = UIManager.getInstalledLookAndFeels();
		// création de la fenêtre
		fen = new JFrame("Application Swing");
		// ajout des composants
		fen.getContentPane().add(panelPrincipal(), BorderLayout.CENTER);
		// écouteur pour fermeture de la fenêtre
		fen.addWindowListener(new Fermeture());
		// mise en place et affichage
		fen.pack();
		fen.setBounds(50, 50, 200, 150);
		fen.setVisible(true);
	}

	/*
	 * création des composants et insertion dans un JPanel
	 */

	public Component panelPrincipal() {
		// -------------label nom de style (look and feel)
		nomStyle = new JLabel("LAF: " + UIManager.getLookAndFeel().getName(), SwingConstants.CENTER);
		// nomStyle.setBorder(BorderFactory.createEtchedBorder());
		// -------------bouton de changement de style
		changeLAF = new JButton("Change");
		// écouteur
		changeLAF.addActionListener(new ActionBouton());
		// -------------le JPanel qui contient le reste
		// un moyen commode consiste à insérer les composants dans
		// un JPanel qui sera lui même insérer dans la fenêtre principale
		JPanel pane = new JPanel();
		// définir une bordure, ici vide avec marge
		pane.setBorder(BorderFactory.createEmptyBorder(10, // top
				10, // left
				10, // bottom
				10) // right
		);
		// ajout des composants
		pane.setLayout(new GridLayout(2, 1, 10, 10));
		pane.add(nomStyle);
		pane.add(changeLAF);
		return pane;
	}

	/**
	 * classe de réponse au bouton de changement de style
	 */

	class ActionBouton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// on passe au numéro de style suivant ou 0
			lafNo = (lafNo + 1) % laf.length;
			// on essaie d'effectuer le changement
			try {
				UIManager.setLookAndFeel(laf[lafNo].getClassName());
				SwingUtilities.updateComponentTreeUI(fen);
				nomStyle.setText("LAF: " + UIManager.getLookAndFeel().getName());
			} catch (Exception exc) {
			}
			fen.repaint();
		}
	}

	/**
	 * classe gérant la fermeture de la fenêtre
	 */
	class Fermeture extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			fen.setVisible(false);
			System.exit(0);
		}
	}

	/**
	 * Méthode principale de l'application
	 */
	public static void main(String[] args) {
		System.out.println("Chargement en cours...");
		new SwingApplication();
	}

}
