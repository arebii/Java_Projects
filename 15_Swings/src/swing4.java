
import javax.swing.*;
import java.awt.event.*;

public class swing4 extends JFrame {
	
	public swing4() {
		
		super("titre de l'application");
		
		
		addWindowListener(new Fermeture());
		
		ImageIcon imageNormale = new ImageIcon("kmaila.gif");
		ImageIcon imagePassage = new ImageIcon("logo_google.gif");
		ImageIcon imageEnfoncee = new ImageIcon("tria.gif");
		
		JButton bouton = new JButton("Mon bouton", imageNormale);
		
		bouton.setPressedIcon(imageEnfoncee);
		bouton.setRolloverIcon(imagePassage);
		bouton.setRolloverEnabled(true);
		
		getContentPane().add(bouton, "Center");
		
		
		
		setSize(200, 100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		JFrame frame = new swing4();
	}
}
