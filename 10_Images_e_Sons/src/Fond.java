import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Fond extends Applet {
	Image img;

	int largeurImage;
	int hauteurImage;

	public void init() {

		MediaTracker m = new MediaTracker(this);

		img = getImage(getCodeBase(), "desert.jpg");
		m.addImage(img, 0);
		try {
			m.waitForID(0);
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}

		largeurImage = img.getWidth(this);
		hauteurImage = img.getHeight(this);
	}

	public void ligne(Graphics g, int y) {
		int x = 0;
		while (x < getSize().width) {
			g.drawImage(img, x, y, this);
			x = x + largeurImage;
		}
	}

	public void paint(Graphics g) {
		if (img != null) {
			int y = 0;
			while (y < getSize().height) {
				ligne(g, y);
				y = y + hauteurImage;
			}
		}
	}
}