import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Swing5 extends JFrame implements ActionListener{

	public Swing5() {

		super("titre de l'application");
		setSize(200,200);
		JButton b = new JButton("Quitter");
		b.addActionListener(this);
		
		JPanel pannelPrincipal = (JPanel)getContentPane();
		
		pannelPrincipal.setLayout(new BorderLayout());
		
		pannelPrincipal.add(BorderLayout.CENTER, b);
		
		getRootPane().setDefaultButton(b); // definir le bouton3 par defaut
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2 , dim.height/2 - getHeight()/2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Swing5();
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

}
