import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class TextDefilant extends Applet implements Runnable {
	
	String msg = null; 			// message affiché
	Thread processus = null; 	// le processus
	int x_coord = 0; 			// coordonnées d'affichage
	int y_coord = 0;
	int largeur = 0;
	int longueur = 0;
	
	int len = 0; 				// longueur du message
	int speed = 20; 			// temps de pause
//pour le double buffering
	Image img = null; 			// image en mémoire
	Graphics gi = null; 		// contexte graphique pour l'image

	public void init() {
		setSize(600,300);
		msg = "Texte défilant";
		largeur = getSize().width;
		longueur = getSize().height;
		setFont(new Font("TimesRoman", Font.BOLD, 36));
		setBackground(Color.white);
		setForeground(Color.red);
	}

	public void start() {
		if (processus == null) {
			processus = new Thread(this);
			processus.start();
		}
	}

	public void stop() {
		if (processus != null)
			processus.stop();
		processus = null;
	}

	public void run() {
		while (processus != null) {
			faireImage();
			repaint();
			x_coord--;
			if (x_coord <= -len)
				x_coord = getSize().width;
			try {
				processus.sleep(speed);
			} catch (InterruptedException e) {
			}
		}
		processus = null;
	}

	public void faireImage() {
		//img = null;
		if (len == 0) { // calcul des mesures du texte
			img = createImage(largeur, longueur);
			gi = img.getGraphics();
			FontMetrics fm = gi.getFontMetrics();
			len = fm.stringWidth(msg);
			x_coord = getSize().width;
			y_coord = (longueur - fm.getHeight()) / 2 + fm.getAscent();
		}
		gi.setColor(getBackground());
		gi.fillRect(0, 0, largeur, longueur);
		gi.setColor(getForeground());
		gi.drawString(msg, x_coord, y_coord);
	}

	public void paint(Graphics g) {
		if (img != null)
		{
			g.drawImage(img, 0, 0, this);
			largeur = getSize().width;
			longueur = getSize().height;
			//
		}
			
	}

	public void update(Graphics g) {
		paint(g);
	}
}
