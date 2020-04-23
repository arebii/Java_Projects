import java.awt.*;
import java.awt.event.*;

class MsgBox2 extends Dialog implements ActionListener {
	boolean id = false; // permet de connaître le bouton utilisé
	Button ok, can;
	TextField nom, tel;
	Label l;

	MsgBox2(Frame fr, String msg, boolean okcan) {
		// constructeur hérité
		super(fr, "Message", true);
		// gestionnaire de positionnement
		setLayout(new BorderLayout());

		// boutons
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		ok = new Button(" OK ");
		p.add(ok);
		ok.addActionListener(this);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 4));

		l = new Label("Nom :");
		nom = new TextField(10);
		p1.add(l);
		p1.add(nom);

		l = new Label("Tel :");
		tel = new TextField(10);
		p1.add(l);
		p1.add(tel);

		// ligne de message
		add(BorderLayout.CENTER, p1);

		if (okcan) {
			can = new Button("Annuler");
			p.add(can);
			can.addActionListener(this);
		}
		add(BorderLayout.SOUTH, p);
		// dimensions et positionnement
		pack();
		Dimension d = getToolkit().getScreenSize();
		setLocation(d.width / 3, d.height / 3);
		// affichage
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			id = true;
			setVisible(false);
		} else if (e.getSource() == can) {
			id = false;
			setVisible(false);
		}
	}

	public static String affMsg(Frame fr, String msg) {
		String rep = "";
		MsgBox2 message = new MsgBox2(fr, msg, false);
		message.dispose();
		if (message.nom.getText().isEmpty() || message.tel.getText().isEmpty()) {
			rep = "false";
		} else {		
			rep = message.nom.getText() + ":" + message.tel.getText();
		}
		return rep;
	}

	public static boolean affQuest(Frame fr, String msg) {
		MsgBox2 message = new MsgBox2(fr, msg, true);
		boolean rep = message.id;
		message.dispose();
		return rep;
	}

}