
import java.applet.*;
import java.awt.*;


public class Exo2 extends Applet {
	String msg;

	public void init() {
		msg = "Mon texte";
		setBackground(Color.white);
		setForeground(Color.black);
		setFont(new Font("Serif", Font.BOLD, 20));
	}

	public void paint(Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int largeur = fm.stringWidth(msg);
		int hauteur = fm.getHeight();
		int x = (getSize().width - largeur) / 2;
		int y = (getSize().height - hauteur) / 2;
		// encadrement 3D
		g.setColor(Color.lightGray);
		g.fill3DRect(x - 8, y - 8, largeur + 16, hauteur + 16, true);
		g.draw3DRect(x - 8, y - 8, largeur + 16, hauteur + 16, true);
		g.draw3DRect(x - 6, y - 6, largeur + 12, hauteur + 12, false);
		// attention il faut écrire sur la ligne de base
		// d'où le calcul de l'ordonnée
		g.setColor(Color.black);
		g.drawString(msg, x, y + fm.getAscent());
	}

}