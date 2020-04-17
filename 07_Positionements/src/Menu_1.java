import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

 

import javax.swing.JButton;

 

public class Menu_1 extends Applet implements ActionListener {
    CardLayout carte;
    JButton bouton=new JButton("Entree");
    ArrayList<String> other = new ArrayList<String>();
    ArrayList<String>  entree = new ArrayList<String>();
    ArrayList<String>  plat= new ArrayList<String>();
    ArrayList<String>  dessert = new ArrayList<String>();
    float[] prix_entree = {(float) 3.4, (float) 4.5, (float) 3.75};
    float[] prix_plat = {(float) 5.4, (float) 4.9, (float) 8.75};
    float[] prix_dessert = {(float) 1.4, (float) 3.5, (float) 1.75};

 

    TextField e1 = new TextField(5);
    TextField e2 = new TextField(5);
    TextField e3 = new TextField(5);
    TextField pl1 = new TextField(5);
    TextField pl2 = new TextField(5);
    TextField pl3 = new TextField(5);
    TextField d1 = new TextField(5);
    TextField d2 = new TextField(5);
    TextField d3 = new TextField(5);

 

    Panel repas,p1, p2, p3;
    int i = 0;
    TextArea ta = new TextArea();
    ArrayList<String> menu = new ArrayList<>();
    float tot = 0;

 

    public void init() {
        other.add("Plat");
        other.add("Dessert");
        other.add("Entree");
        entree.add("salade");
        entree.add("tomate");
        entree.add("oignons");
        plat.add("poulet");
        plat.add("Poulet");
        plat.add("POULET");
        dessert.add("tarte");
        dessert.add("ta");
        dessert.add("tin");

 

        setSize(400,400);
        p1 = new Panel();
        p1.setLayout(new GridLayout(3,2));
        ajouteBouton(entree.get(0),p1);
        e1.setText(String.valueOf(prix_entree[0]));
        p1.add(e1);
        ajouteBouton(entree.get(1),p1);
        e2.setText(String.valueOf(prix_entree[1]));
        p1.add(e2);
        ajouteBouton(entree.get(2),p1);
        e3.setText(String.valueOf(prix_entree[2]));
        p1.add(e3);
        p1.setBackground(Color.orange);

 

        p2 = new Panel();
        p2.setLayout(new GridLayout(3,2));
        ajouteBouton(plat.get(0),p2);
        pl1.setText(String.valueOf(prix_plat[0]));
        p2.add(pl1);
        ajouteBouton(plat.get(1),p2);
        pl2.setText(String.valueOf(prix_plat[1]));
        p2.add(pl2);
        ajouteBouton(plat.get(2),p2);
        pl3.setText(String.valueOf(prix_plat[2]));
        p2.add(pl3);
        p2.setBackground(Color.green);

 

        p3 = new Panel();
        p3.setLayout(new GridLayout(3,2));
        ajouteBouton(dessert.get(0),p3);
        d1.setText(String.valueOf(prix_dessert[0]));
        p3.add(d1);
        ajouteBouton(dessert.get(1),p3);
        d2.setText(String.valueOf(prix_dessert[1]));
        p3.add(d2);
        ajouteBouton(dessert.get(2),p3);
        d3.setText(String.valueOf(prix_dessert[2]));
        p3.add(d3);
        p3.setBackground(Color.yellow);

 


        //panel contenant les deux précédents
        repas=new Panel();
        carte = new CardLayout();
        repas.setLayout(carte);
        repas.add("entree", p1);
        repas.add("plat", p2);
        repas.add("dessert", p3);
        setLayout(new BorderLayout());
        add("North", bouton);
        add("Center", repas);
        add(BorderLayout.SOUTH, ta);
        bouton.addActionListener(this);
    }

 

    void ajouteBouton(String S, Panel p) {
        Button but=new Button(S);
        p.add(but);
        but.addActionListener(this);
    }

 

    public void actionPerformed(ActionEvent e) {
        carte.next(repas);
        bouton.setText(other.get(i %3));
        System.out.println(i);
        if ( i%3 == 0) {
            System.out.println(entree.indexOf(e.getActionCommand()));
            tot += prix_entree[entree.indexOf(e.getActionCommand())];            
        }
        if ( i%3 == 1) {
            System.out.println(plat.indexOf(e.getActionCommand()));
            tot += prix_entree[plat.indexOf(e.getActionCommand())];
        }
        if ( i%3 == 2) {
            System.out.println(dessert.indexOf(e.getActionCommand()));
            tot += prix_entree[dessert.indexOf(e.getActionCommand())];
        }

 

 

        i++;
        menu.add(e.getActionCommand());
        if (menu.size() == 3) {
            ta.append("L'entree : " + menu.get(0) + '\n');
            ta.append("Le plat : " + menu.get(1) + '\n');
            ta.append("Le dessert : " + menu.get(2) + '\n');
            ta.append("Pour un total de " + String.valueOf(tot) + " Euros");
            menu.clear();
        }

 

    }
}
