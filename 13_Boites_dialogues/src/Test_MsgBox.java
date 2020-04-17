import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Test_MsgBox extends Applet implements ActionListener {
	
	
	public void init() {
		setLayout(new BorderLayout());
		Button b = new Button(" Message ");
		b.addActionListener(this);
		add(BorderLayout.CENTER, b);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		//on cherche un objet de type Frame contenant l'applet
		
		Frame fr = null;
		
		Component parentCourant = this;
		
		while (parentCourant != null && fr == null) {
			if (parentCourant instanceof Frame)
				fr = (Frame) parentCourant;
			else
				parentCourant = parentCourant.getParent();
		}
		
		MsgBox.affMsg(fr, "Bonjour dans une boîte de message !");
		//MsgBox.affQuest(fr, "Bonjour dans une boîte de message !");
	}
}