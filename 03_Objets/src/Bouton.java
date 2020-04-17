import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Bouton extends Applet implements ActionListener {

	int nombre;
	TextField tf;

	public void init() {

		setSize(400, 400);
		Button b = new Button("Ajouter");
		add(b);
		b.addActionListener(this);
		nombre =0;
		tf = new TextField(10);
		add(tf);
		tf.addActionListener(this);
		

	}

	public void paint(Graphics g) {
		g.drawString(""+nombre,50,80);
		}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		
		if (evt.getSource().equals(tf)) {
			// on augmente nombre d'une unité
			nombre++;
			// on réaffiche
			repaint();
		}
	}

}
