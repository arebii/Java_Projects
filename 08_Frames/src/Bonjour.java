import java.awt.*;
import java.awt.event.*;

public class Bonjour extends Frame {

	public Bonjour() {
		setBackground(Color.white);
		setSize(300, 200);
		setTitle("Essai");
		
		Exo5 dessin = new Exo5();
		add(dessin); // placement du dessin 
		dessin.init();
		dessin.start();
		
		addWindowListener(new Fermeture());
	}
/*	
	public void paint(Graphics g) {
		int x=(getSize().width-80)/2;
		int y=(getSize().height-20)/2;
		g.drawString("Bonjour !", x,y);
		}
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bonjour bj = new Bonjour();
		bj.show();
	}

	

}
