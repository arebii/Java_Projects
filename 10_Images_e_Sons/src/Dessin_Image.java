
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Dessin_Image extends Applet implements MouseListener, MouseMotionListener {
	Image img = null;
	Graphics gi = null;
	
	int oldx = -1;
	int oldy = -1;

	public void init() {
		
		setSize(500,500);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		img = createImage(getSize().width, getSize().height);
		gi = img.getGraphics();
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

//Gestion de l'événement "bouton de la souris enfoncé"
	public void mousePressed(MouseEvent evt) {
		oldx = evt.getX();
		oldy = evt.getY();
		gi.drawLine(oldx, oldy, oldx, oldy);
		repaint();
	}

//Gestion de l'événement "bouton de la souris relevé"
	public void mouseReleased(MouseEvent evt) {
		if (oldx >= 0 && oldy >= 0) {
			gi.drawLine(oldx, oldy, evt.getX(), evt.getY());
			oldx = -1;
			oldy = -1;
			repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

// Gestion de l'événement "déplacement souris avec bouton enfoncé"
	public void mouseDragged(MouseEvent evt) {
		if (oldx >= 0 && oldy >= 0) {
			int newx = evt.getX();
			int newy = evt.getY();
			gi.drawLine(oldx, oldy, newx, newy);
			oldx = newx;
			oldy = newy;
			
			repaint();
		}
	}

public void mouseMoved(MouseEvent evt) {}
}