
import java.awt.*;
import java.applet.*;

/** Applet affichant des carrés dont la couleur, la position
 *  et la dimension est choisie au hasard.
 *  Il suffit de masquer le contenu de l'applet (par exemple
 *  en iconisant la fenêtre du navigateur) puis de la refaire
 *  apparaitre pour obtenir un nouveau dessin.
 *  Normal : chaque appel à la méthode paint produit un nouveau
 *  dessin.
 */
import java.awt.*; // Graphique
import java.applet.*; // Applet

 

public class Exo5 extends Applet {

 

    Color col;

    boolean flag = false;

    public void init() {
        setSize(500, 500);
    }

 

    public void modeCarre()
    {
    	flag = false;
    	repaint();
    	
    }
    public void modeCercle()
    {
    	flag = true;
    	repaint();
    	
    }
    public void paint(Graphics g) {

 

        int largeur = getWidth();
        int hauteur = getHeight();

 

        for (int i = 0; i < 100; i++) {
            int r = (int) (Math.random() * 250);
            int v = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

 

            // Position de debut du carre
            int rand_x = (int) (Math.random() * largeur);
            int rand_y = (int) (Math.random() * hauteur);

 

            // Cote du carre
            int min_x = largeur - rand_x;
            int min_y = hauteur - rand_y;

 

            int rand_width = (int) (Math.random() * Math.min(min_x, min_y));

 

            col = new Color(r, v, b);
            g.setColor(col);
            if ( flag == false)
            {
            	g.fillRect(rand_x, rand_y, rand_width, rand_width);
            	
            }
            else
            {
            	g.fillOval(rand_x, rand_y, rand_width, rand_width);
            }
            

 

        }
    }
}