
import javax.swing.*;
import java.awt.event.*;


public class Swing2 extends JFrame {
	
	public Swing2() {

		super("mon titre");
		/*
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		*/
		
		addWindowListener(new Fermeture());
		
		JButton bouton = new JButton("Mon bouton");
		
		
		JPanel panneau = new JPanel();
		
		panneau.add(bouton);
		
		setContentPane(panneau);
		
		
		
		setSize(200, 100);
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		JFrame frame = new Swing2();
	}
}
