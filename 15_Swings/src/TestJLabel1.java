
import javax.swing.*;
import java.awt.*;

public class TestJLabel1 {
	public static void main(String argv[]) {
		
		JFrame f = new JFrame("Test JLabel");
		
		f.setSize(300, 300);
		
		ImageIcon image = new ImageIcon("Image10.jpg");
    	
    	f.setIconImage(image.getImage());
    	
		JPanel pannel = new JPanel();
		pannel.setLayout(new GridLayout(3,1,10,10));
		
		JLabel jLabel1 = new JLabel("Mon texte dans JLabel");
		
		pannel.add(jLabel1);
		
		ImageIcon icone = new ImageIcon("Image10.jpg");
		JLabel jLabel2 = new JLabel(icone);
		
		pannel.add(jLabel2);
		
		JLabel jLabel3 = new JLabel("Mon texte", icone, SwingConstants.LEFT);
		pannel.add(jLabel3);
		
	
		f.getContentPane().add(pannel);
		
		
		f.setVisible(true);
	}
}
