import java.awt.*;

import javax.swing.*;

public class TestJFrame1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("ma fenetre");
		JPanel panelPricipal = (JPanel)f.getContentPane();
		panelPricipal.setLayout(new BorderLayout());
		JButton b = new JButton("mon bouton");
		panelPricipal.add(BorderLayout.NORTH,b);
		
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Fichier");
		
		JMenuItem menuItem = new JMenuItem("Quitter");
		menu.add(menuItem);
		menuBar.add(menu);
		
		f.setSize(300,100);
		
		
		f.setVisible(true);
		
	
	}

}
