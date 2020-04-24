
import javax.swing.*;
import java.awt.*;

public class TestJButton2 {
	public static void main(String argv[]) {
		
		JFrame f = new JFrame("ma fenetre");
		f.setSize(300, 100);
		
		JPanel pannel = new JPanel();
		
		JButton bouton1 = new JButton("Bouton 1");
		pannel.add(bouton1);
		JToggleButton bouton2 = new JToggleButton("Bouton 2");
		pannel.add(bouton2);
		JButton bouton3 = new JButton("Bouton 3");
		pannel.add(bouton3);
		
		f.getContentPane().add(pannel);
		
		f.getRootPane().setDefaultButton(bouton3); // definir le bouton3 par defaut
		f.setVisible(true);
	}
}