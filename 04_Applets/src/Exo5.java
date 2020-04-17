
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
public class Exo5 extends Applet {
 
 //nombre de carrés à dessiner
 int nbCars;
    
 /**
  * Initialisation du nombre de carrés et de la
  * couleur de fond
  */
 public void init() {
  nbCars=20;
  setBackground(Color.white);
 }
 
 /**
  * Tirer un nombre au hasard entre 0 et n (n exclus)
  */
 int hasard(int n) {
  Double D=new Double(Math.random()*n);
  return D.intValue();
  // ou
  // return (int)Math.floor(Math.random()*n); 
 }

 /**
  * Dessiner un carré : couleur, position et taille sont
  * tirés au hasard en utilisant la méthode hasard.
  */
 void dessineCarre(Graphics g) {
  //choix de la couleur
  Color col=new Color(hasard(256),hasard(256),hasard(256));
  //maximum pour coordonnées et côté
  int min=Math.min(getSize().width/2,getSize().height/2);
  //coordonnées
  int x=hasard(min);
  int y=hasard(min);
  //côté
  int c=hasard(min);
  //on trace
  g.setColor(col);
  g.fillRect(x,y,c,c);
 }

 /**
  * La méthode paint dessine nbCars carrés en appelant la
  * la méthode de dessin d'un carré autant de fois que
  * nécessaire.
  */
 public void paint(Graphics g)	{
  for (int i=0; i< nbCars ; i++) dessineCarre(g);
 }

}
	