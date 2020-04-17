import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TestClavier extends Applet implements KeyListener {

	String S = "";

	public void init() {

		setSize(400, 400);
		addKeyListener(this);

	}

	public void start() {
		requestFocus();
	}

	public void paint(Graphics g) {
		g.drawString("Ecrire un mot de 10 lettres...", 10, 30);
		g.drawString(S, 10, 60);
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		
		
		if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			S="";
			repaint();
		}
		else
		{
			char Caract = evt.getKeyChar();
			if (S.length() < 10)
				if (Caract != 0) {
					S = S + Caract;
					repaint();
				}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
