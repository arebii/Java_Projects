import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Menu extends Applet implements ActionListener{
	
	CardLayout carte;
	Panel Entrees;
	Panel Viandes;
	Panel Desserts;
	Panel Menu_G;
	Button bouton = new Button("Entree, Viande  ou Dessert");
	TextArea ta;
	
	
	public void init() {
			   setSize(600,600);
		//panel de la première carte (les fruits)
				Entrees = new Panel();
				Entrees.setLayout(new GridLayout(4,4));
				
				place_bouton(Entrees,"Salade_0", "5€" );
				
				place_bouton(Entrees,"Salade_1" , "4€");
				place_bouton(Entrees,"Salade_2" , "3€");
				place_bouton(Entrees,"Salade_3" , "6€");
				
				Entrees.setBackground(Color.green);
		//panel de la deuxieme carte (les legumes)
				Viandes = new Panel();
				Viandes.add(new Button("Viande_0"));
				Viandes.add(new Button("Viande_1"));
				Viandes.add(new Button("Viande_2"));
				Viandes.setBackground(Color.red);
				
				Desserts = new Panel();
				Desserts.add(new Button("Dessert_0"));
				Desserts.add(new Button("Dessert_1"));
				Desserts.add(new Button("Dessert_2"));
				Desserts.setBackground(Color.yellow);
		//panel contenant les deux précédents
				Menu_G = new Panel();
				
				carte = new CardLayout();
				Menu_G.setLayout(carte);
				Menu_G.add("Entrees", Entrees);
				Menu_G.add("Viandes", Viandes);
				Menu_G.add("Desserts", Desserts);
				
				setLayout(new BorderLayout());
				add("North", bouton);
				add("Center", Menu_G);
				ta = new TextArea();
				ta.setText("");
				add("South", ta);
				bouton.addActionListener(this);
			}
	
	
	public void place_bouton(Panel p, String s, String l)
	{
		Button but = new Button(s);
		p.add(but);
		but.setName(l);
		p.add(new Label (l));
		
		but.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		carte.next(Menu_G);
		System.out.println(e.getSource().hashCode());
		ta.appendText(e.getActionCommand()+"\n");
		
		//bouton.setLabel(p1.getName());
	}

}
