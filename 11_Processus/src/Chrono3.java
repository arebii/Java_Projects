import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Chrono3 extends Applet implements Runnable, ActionListener {
	private Thread chronometre;
	int speed = 100;
	private int ds = 0; // dixième de seconde
    boolean wait = false;
    Button start, stop, pause;
    
	public void init() {
		setBackground(Color.white);
		setForeground(Color.blue);
		setFont(new Font("SansSerif", Font.BOLD, getSize().height));
		Button b;
	}

	public void start() {
// Au début de l'applet, création et démarrage du chronomètre
		if (chronometre == null) {
			chronometre = new Thread(this);
			chronometre.start();
		}
	}

	public void run() {
		while (chronometre != null) {
			repaint();
			if (wait == false)
			{
				ds++;
				
			}
			try {
				chronometre.sleep(speed);
			} catch (InterruptedException e) {
			}
		}
	}

	public void stop() {
// A la fin de l'applet, arrêt du chronometre
		chronometre.stop();
		chronometre = null;
	}

	public void paint(Graphics g) {
// Dessine le temps écoulé sous forme de h:mm:ss:d
		String S = ds / 36000 + ":" + (ds / 6000) % 6 + (ds / 600) % 10 + ":" + (ds / 100) % 6 + (ds / 10) % 10 + ":"
				+ ds % 10;
//affichage centré
		FontMetrics fm = g.getFontMetrics();

		int largeur = fm.stringWidth(S);
		int hauteur = fm.getHeight();
		int x = (getSize().width - largeur) / 2;
		int y = (getSize().height - hauteur) / 2;
		g.drawString(S, x, y + hauteur - fm.getDescent());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}