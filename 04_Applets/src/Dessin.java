import java.awt.*; // Graphique 
import java.applet.*; // Applet 

public class Dessin extends Applet {

	
public void init() {
		
		setSize(400,400);
		
	}

public void paint(Graphics g) {
	
	//ciel
	g.setColor(Color.blue);
	g.fillRect(0,0,300,110);
	//prairie
	g.setColor(Color.green);
	g.fillRect(0,110,300,90);
	//soleil
	g.setColor(Color.yellow);
	g.fillOval(220,20,30,30);
	//mur de la maison
	g.setColor(Color.white);
	g.fillRect(80,100,50,70);
	g.setColor(Color.black);
	g.drawRect(80,100,50,70);
	//porte
	g.drawRect(90,140,20,30);
	g.drawLine(110,155,105,155);
	
	//toit en triangle
	int[] x={80,130,105};
	int[] y={100,100,50};
	g.setColor(Color.red);
	g.fillPolygon(x,y,3);
	g.setColor(Color.black);
	g.drawPolygon(x,y,3);
	
}
}
