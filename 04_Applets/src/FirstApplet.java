import java.awt.*; // Graphique 
import java.applet.*; // Applet 

public class FirstApplet extends Applet {
	
	
	String msg = "Bonjour";

	public void init() {
		
		setSize(200,300);
		//col = new Color(255, 0, 0);
		setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,20));
		setBackground(Color.black);
		setForeground(Color.yellow);
		

	}

	public void paint(Graphics g) {
		
		FontMetrics fm=getFontMetrics(getFont());
		//getSize().width donne la largeur totale
		int y = getSize().height;
		int x=(getSize().width-fm.stringWidth(msg))/2;
		g.drawString(msg, x, y/2);

	}

}
