
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Son extends Applet implements ActionListener {
	
	AudioClip ding;
	AudioClip fond;
	
	Button bding = new Button("DING");
	Button bfond = new Button("DEPART");
	boolean bruitFond = false;

	public void init() {
		ding = getAudioClip(getCodeBase(), "ding.au");
		fond = getAudioClip(getCodeBase(), "oiseau.au");
		add(bding);
		bding.addActionListener(this);
		add(bfond);
		bfond.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bding)
			ding.play();
		else if (e.getSource() == bfond) {
			if (bruitFond) {
				fond.stop();
				bfond.setLabel("DEPART");
				bruitFond = false;
			} else {
				fond.loop();
				bfond.setLabel("STOP");
				bruitFond = true;
			}
		}
	}

	public void stop() {
		if (bruitFond)
			fond.stop();
	}
}
