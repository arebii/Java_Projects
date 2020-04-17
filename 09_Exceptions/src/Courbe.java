import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

 

public class Courbe extends Frame implements ActionListener {

 

    TextField mesures;
    int hauteur_h[] = new int[100];
    int counter = 0;
    TextField err;
    boolean flag = false;
 

    public Courbe() {
        setSize(500, 500);
        MenuItem mi;
        
        setTitle("Tracé de courbes");
        mesures = new TextField(50);
        setLayout(new BorderLayout());
        mesures.addActionListener(this);
        add(BorderLayout.NORTH, mesures);
        err = new TextField(150);
        err.setEditable(false);
        add(BorderLayout.SOUTH, err);

 

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
        // item Quitter
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
        
        mb.add(m2);
        mi = new MenuItem("Quitter");
        mi.addActionListener(this);
        m1.add(mi);

 

        addWindowListener(new Fermeture());

 

    }

 

    public double moyenne(int[] tab, int count) {
        double res = 0;
        for (int i = 0; i < count; i++) {
            res += tab[i];

 

        }
        res /= count;
        res = (int) (res * 100) / 100.0;
        return res;
    }

 

    public double ecart_type(int[] tab, int count) {
        double res = 0;
        double moy = moyenne(tab, count);
        for (int i = 0; i < count; i++) {
            res += Math.pow((tab[i] - moy), 2);
        }
        res = Math.sqrt(res);
        res = (int) (res * 100) / 100.0;

 

        return res;
    }

 

    public void paint(Graphics g) {
        int largeur = getWidth();
        int hauteur = getHeight();
        int largeur_barre = 25;
        int or_x = 0;
        int or_y = hauteur;
        int step = 15;
        
        for (int i = 0; i < counter; i++) {
            int r = (int) (Math.random() * 250);
            int v = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);
            
            g.setColor(new Color(r, v, b));
            
            if (flag ==  true)
            {
            	g.fillRect((or_x), (or_y - hauteur_h[i]), largeur_barre, hauteur_h[i]);
                or_x += largeur_barre + step;
            }
            else
            {
            	if ( i < counter - 1 )
            	{
            		g.drawLine(or_x, or_y - hauteur_h[i]  , or_x + step, or_y - hauteur_h[i+1]);
                	or_x += step;
            	}
            	
            	
            }
            
        }

 

    }

 

    public static void main(String[] args) {
        Courbe cr = new Courbe();
        cr.setVisible(true);
    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        StringTokenizer st = new StringTokenizer(mesures.getText());
        while (st.hasMoreTokens()) {
            try {
                hauteur_h[i] = Integer.parseInt(st.nextToken());
                i++;
            } catch (Exception er) {
                System.out.println(er.toString());
            }
        }
        counter = i;
        repaint();
        err.setText("Moyenne :" + moyenne(hauteur_h, counter) + " et l'ecart type" + ecart_type(hauteur_h, counter));

 

        // if Item reset
        if (e.getActionCommand().equals("Reset")) {
            for (int j = 0; j < counter; j++) {
                hauteur_h[j] = 0;
            }
            counter = 0;
            err.setText("");
            mesures.setText("");
        }

 

        // if Item quitter
        if (e.getActionCommand().equals("Quitter")) {
            System.exit(0);
        }

 

        // if Item refresh
        if (e.getActionCommand().equals("Refresh")) {
            repaint();
        }
    }
}