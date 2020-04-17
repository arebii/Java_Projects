import java.awt.*;
import java.awt.event.*;

class Fermeture extends WindowAdapter {
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}