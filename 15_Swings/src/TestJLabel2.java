
import javax.swing.*;
import java.awt.*;

public class TestJLabel2 {
	public static void main(String argv[]) {
		
		JFrame f = new JFrame("ma fenetre");
		
		f.setSize(100, 200);
		JPanel pannel = new JPanel();

		JLabel jLabel1 = new JLabel("Mon texte dans JLabel 1");
		
		jLabel1.setBackground(Color.red);
		jLabel1.setOpaque(true);
		
		pannel.add(jLabel1);
		
		JLabel jLabel2 = new JLabel("Mon texte dans JLabel 2");
		
		jLabel2.setBackground(Color.red);
		
		jLabel2.setOpaque(true);
		
		pannel.add(jLabel2);
		
		f.getContentPane().add(pannel);
		
		f.setVisible(true);
	}
}