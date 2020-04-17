import java.awt.*;
import java.awt.event.*;

public class Frame_Courbe extends Frame implements ActionListener {

	Courbe C;

	public Frame_Courbe() {

		setSize(500, 500);
		MenuItem mi;
		setTitle("Tracé de courbes");

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		// menu Fichier
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		// item refresh
		mi = new MenuItem("Reset");
		mi.addActionListener(this);
		m1.add(mi);
		// item refresh
		mi = new MenuItem("Refresh");
		mi.addActionListener(this);
		m1.add(mi);
		Menu m2 = new Menu("Edition");
		mb.add(m1);
		// item refresh
		mi = new MenuItem("Histo");
		mi.addActionListener(this);
		m2.add(mi);
		// item refresh
		mi = new MenuItem("Courbe");
		mi.addActionListener(this);
		m2.add(mi);
		// item Quitter
		mb.add(m2);
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);

		addWindowListener(new Fermeture());

		C = new Courbe();

		add(C);

		C.init();
		C.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame_Courbe FC = new Frame_Courbe();
		FC.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Quitter")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Courbe")) {

			C.mode_courbe();
		} else if (e.getActionCommand().equals("Histo"))
		{
			C.mode_histo();
		}

	}

}
