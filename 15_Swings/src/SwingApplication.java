/**
 * Exemple d'application swing
 */

//importation du package swing
import javax.swing.*; //nom final du package
//import com.sun.java.swing.*; //utilis� par JDK 1.1 et swing.jar
import java.awt.*;
import java.awt.event.*;

/**
 * classe principale : elle contient une m�thode createComponents qui renvoie un
 * JPanel � ins�rer dans une fen�tre
 */

public class SwingApplication {

	JFrame fen; // fen�tre de l'application
	JButton changeLAF; // bouton changement de style
	UIManager.LookAndFeelInfo laf[]; // styles disponibles
	int lafNo = 0; // num�ro style courant
	JLabel nomStyle; // nom du style utilis�

	public SwingApplication() {
		// chargement des styles disponibles
		laf = UIManager.getInstalledLookAndFeels();
		// cr�ation de la fen�tre
		fen = new JFrame("Application Swing");
		// ajout des composants
		fen.getContentPane().add(panelPrincipal(), BorderLayout.CENTER);
		// �couteur pour fermeture de la fen�tre
		fen.addWindowListener(new Fermeture());
		// mise en place et affichage
		fen.pack();
		fen.setBounds(50, 50, 200, 150);
		fen.setVisible(true);
	}

	/*
	 * cr�ation des composants et insertion dans un JPanel
	 */

	public Component panelPrincipal() {
		// -------------label nom de style (look and feel)
		nomStyle = new JLabel("LAF: " + UIManager.getLookAndFeel().getName(), SwingConstants.CENTER);
		// nomStyle.setBorder(BorderFactory.createEtchedBorder());
		// -------------bouton de changement de style
		changeLAF = new JButton("Change");
		// �couteur
		changeLAF.addActionListener(new ActionBouton());
		// -------------le JPanel qui contient le reste
		// un moyen commode consiste � ins�rer les composants dans
		// un JPanel qui sera lui m�me ins�rer dans la fen�tre principale
		JPanel pane = new JPanel();
		// d�finir une bordure, ici vide avec marge
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
	 * classe de r�ponse au bouton de changement de style
	 */

	class ActionBouton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// on passe au num�ro de style suivant ou 0
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
	 * classe g�rant la fermeture de la fen�tre
	 */
	class Fermeture extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			fen.setVisible(false);
			System.exit(0);
		}
	}

	/**
	 * M�thode principale de l'application
	 */
	public static void main(String[] args) {
		System.out.println("Chargement en cours...");
		new SwingApplication();
	}

}
