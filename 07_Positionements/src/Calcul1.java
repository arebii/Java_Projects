import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Calcul1 extends Applet implements ActionListener{
	TextField saisie;
	String value_a, value_b = "";

	public void init() {
		setLayout(new BorderLayout());
		saisie = new TextField(10);
		saisie.setEditable(false);
		Panel bas = new Panel();
		bas.setLayout(new GridLayout(2, 5));
		for (int i = 0; i < 10; i++)
		{
			ajouteBouton(i, bas);
		}
			
		Panel operations = new Panel();
		operations.setLayout(new GridLayout(1,6,4,4));
		operations.add(new Button("+"));
		operations.add(new Button("-"));
		operations.add(new Button("/"));
		operations.add(new Button("x"));
		operations.add(new Button("="));
		operations.add(new Button("C"));
		
		add("North", saisie);
		add("Center", bas);
		add(BorderLayout.SOUTH, operations);
	}

	void ajouteBouton(int a, Panel p) {
		Button but = new Button(""+a);
		but.addActionListener(this);
		p.add(but);
	}

	public String operation ( String a, String op, String b)
	{
		String resultat = "";	
		int val_a, val_b;
		char val_op;
		
		val_a = Integer.parseInt(a);
		val_b = Integer.parseInt(b);
		val_op = op.charAt(0);
		switch (val_op)
		{
		case ('+') :
			resultat = "" + (val_a + val_b);
			break;
		case ('-') :
			resultat = "" + (val_a - val_b);
			break;
		case ('/') :
			resultat = "" + ((double)val_a / val_b);
			//resultat = Double.toString(val_a / val_b);
			break;
		case ('x') :		
			resultat = "" + (val_a * val_b);
			break;		
		default :
			resultat = "";		
		}	
		
		return resultat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
