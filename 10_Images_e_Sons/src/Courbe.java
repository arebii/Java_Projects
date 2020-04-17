import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class Courbe extends Applet implements ActionListener {

	Image img_histo, img_courbe;
	Graphics g1, g2;

	TextField mesures;
	int hauteur_h[] = new int[100];
	int counter = 0;
	TextField err;
	boolean flag = true;

	public void init() {

		setSize(500, 500);

		mesures = new TextField(50);
		setLayout(new BorderLayout());
		mesures.addActionListener(this);
		add(BorderLayout.NORTH, mesures);
		err = new TextField(150);
		err.setEditable(false);
		add(BorderLayout.SOUTH, err);

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

	public void dessin_histo()

	{
		int largeur = getSize().width;
		int hauteur = getSize().height;
		System.out.println("hauteur :" + hauteur);
		int largeur_barre = 25;
		int or_x = 0;
		int or_y = hauteur;
		int step = 15;

		System.out.println("Counter :" + counter);
		

		g1.drawLine(0, 0, 0, hauteur ); // Axe Y
		
		g1.drawLine(0, hauteur-1, largeur , hauteur-1); // Axe X

		for (int i = 0; i < counter; i++) {
			int r = (int) (Math.random() * 250);
			int v = (int) (Math.random() * 250);
			int b = (int) (Math.random() * 250);

			g1.setColor(new Color(r, v, b));

			g1.fillRect((or_x), (or_y - hauteur_h[i]), largeur_barre, hauteur_h[i]);
			or_x += largeur_barre + step;
			System.out.println("histo i :" + i);

		}
	}
	
	public void dessin_courbe()

	{

		int hauteur = getSize().height;
		int largeur = getSize().width;
		System.out.println("hauteur :" + hauteur);
		int largeur_barre = 25;
		int or_x = 0;
		int or_y = hauteur;
		int step = 15;

		System.out.println("Counter :" + counter);

		g2.drawLine(0, 0, 0, hauteur ); // Axe Y
		
		g2.drawLine(0, hauteur-1, largeur , hauteur-1); // Axe X
		
		for (int i = 0; i < counter; i++) {
			int r = (int) (Math.random() * 250);
			int v = (int) (Math.random() * 250);
			int b = (int) (Math.random() * 250);

			g2.setColor(new Color(r, v, b));

			if ( i < counter - 1 )
        	{
        		g2.drawLine(or_x, or_y - hauteur_h[i]  , or_x + step, or_y - hauteur_h[i+1]);
            	or_x += step;
        	}
			
			System.out.println("histo i :" + i);

		}
	}

	public void mode_histo()
	{
		flag = true;
		repaint();
	}
	
	public void mode_courbe()
	{
		flag = false;
		repaint();
	}
	public void paint(Graphics g) {

		if (flag == true) {
			img_histo = createImage(getSize().width, getSize().height);
			g1 = img_histo.getGraphics();
			dessin_histo();

			g.drawImage(img_histo, 20, -40, getSize().width, getSize().height, this);

		}
		else
		{
			img_courbe = createImage(getSize().width, getSize().height);
			g2 = img_courbe.getGraphics();
			dessin_courbe();

			g.drawImage(img_courbe, 20, -40, getSize().width, getSize().height, this);
		}

	}

	public void update(Graphics g) {
		paint(g);
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

		// dessin_histo();
		// dessin_courbe();
		repaint();
		err.setText("Moyenne :" + moyenne(hauteur_h, counter) + " et l'ecart type" + ecart_type(hauteur_h, counter));

	}
}