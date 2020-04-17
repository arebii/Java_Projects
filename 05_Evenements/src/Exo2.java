import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Exo2 extends Applet implements MouseListener, MouseMotionListener {
	
	String msg = "Bonjour";
	int xmsg = 20;
	int ymsg = 20;

	public void init() {

		setSize(400, 400);
		addMouseListener(this);
		addMouseMotionListener(this);

	}
	
	
	public void paint(Graphics g) {
		g.drawString(msg, xmsg, ymsg);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
