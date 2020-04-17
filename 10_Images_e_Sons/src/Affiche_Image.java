import java.applet.*;
import java.awt.*;
import java.net.*;

public class Affiche_Image extends Applet {
	Image img;

	public void init() {
		
		img=getImage(getCodeBase(),"desert.jpg");
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 0, 0, this);
	}
}
