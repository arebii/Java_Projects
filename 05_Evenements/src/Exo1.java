import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Exo1 extends Applet implements KeyListener {

	int tab[] = new int[100];
	int counter = 1;  // Nb de segments 
	
	public void init() {
		setSize(400, 400);
		addKeyListener(this);

		tab[0] = getSize().width / 2;
		tab[1] = 0;
		tab[2] = getSize().width / 2;
		tab[3] = 10;

	}
	public void paint(Graphics g) {

		for (int i = 0; i < counter; i += 2) {
			g.drawLine(tab[i], tab[i + 1], tab[i + 2], tab[i + 3]);

		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_DOWN:
					counter++;  // Nb de segments
					tab[counter * 2] = tab[(counter - 1) * 2];
					tab[(counter * 2) + 1] = tab[((counter - 1) * 2) + 1] + 10;
					break;
				case KeyEvent.VK_UP:
					counter++;  // Nb de segments
					tab[counter * 2] = tab[(counter - 1) * 2];
					tab[(counter * 2) + 1] = tab[((counter - 1) * 2) + 1] - 10;
					break;
				case KeyEvent.VK_RIGHT:
					counter++;  // Nb de segments
					tab[counter * 2] = tab[(counter - 1) * 2] + 10;
					tab[(counter * 2) + 1] = tab[((counter - 1) * 2) + 1];
					break;
				case KeyEvent.VK_LEFT:
					counter++;  // Nb de segments
					tab[counter * 2] = tab[(counter - 1) * 2] - 10;
					tab[(counter * 2) + 1] = tab[((counter - 1) * 2) + 1];
					break;
				case KeyEvent.VK_DELETE:
					counter = 1;  // Nb de segments
					break;

				}

				repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

		

	}

}
