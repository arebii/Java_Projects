import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Mouse extends Applet implements MouseListener, MouseMotionListener {
	
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
	public void mouseClicked(MouseEvent arg0) {

		// TODO Auto-generated method stub
		xmsg = arg0.getX();
		ymsg = arg0.getY();
		System.out.println("Position X:" + xmsg + " Position Y: " + ymsg);
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
		// TODO Auto-generated method stub
		xmsg = arg0.getX();
		ymsg = arg0.getY();
		System.out.println("Position X:" + xmsg + " Position Y: " + ymsg);
		repaint();
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
