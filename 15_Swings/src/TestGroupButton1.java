
import javax.swing.*;

public class TestGroupButton1 {
	
	public static void main(String argv[]) {
		JFrame f = new JFrame("ma fenetre");
		
		f.setSize(300, 100);
		
		JPanel pannel = new JPanel();
		
		ImageIcon imagePassage = new ImageIcon("carre.gif");
		
		ButtonGroup groupe = new ButtonGroup();
		
		JRadioButton bouton1 = new JRadioButton("Bouton 1", true);
		
		groupe.add(bouton1);
		pannel.add(bouton1);
		JRadioButton bouton2 = new JRadioButton(imagePassage);
		groupe.add(bouton2);
		pannel.add(bouton2);
		JRadioButton bouton3 = new JRadioButton("Bouton 3");
		groupe.add(bouton3);
		pannel.add(bouton3);
		
		f.getContentPane().add(pannel);
		f.setVisible(true);
	}
}