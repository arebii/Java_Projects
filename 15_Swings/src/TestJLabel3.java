
import javax.swing.*;
import java.awt.*;

public class TestJLabel3 {
	public static void main(String argv[]) {
		
		JFrame f = new JFrame("ma fenetre");
		
		f.setSize(300, 100);
		
		JPanel pannel = new JPanel();
		
		JButton bouton = new JButton("saisir");
		
		pannel.add(bouton);
		
		JTextField jEdit = new JTextField("votre nom");
		
		JLabel jLabel1 = new JLabel("Nom : ");
		
		jLabel1.setBackground(Color.red);
		
		jLabel1.setDisplayedMnemonic('n');
		
		jLabel1.setLabelFor(jEdit);
		
		pannel.add(jLabel1);
		
		pannel.add(jEdit);
		
		f.getContentPane().add(pannel);
		
		f.setVisible(true);
	}
}