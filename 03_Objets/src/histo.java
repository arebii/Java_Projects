import java.awt.*; // Graphique
import java.applet.*; // Applet
import java.awt.event.*;

 

public class histo extends Applet implements ActionListener{

 

    Color col;
    String non_s = "NON";
    String oui_s = "OUI";
    String opinion = "Sans opinion";
    
    TextField T_oui, T_non, T_sp;
    
 

    public void init() {
        setSize(500, 500);
        T_oui = new TextField(10);
        T_non = new TextField(10);
        T_sp = new TextField(10);
        add(T_oui);
        T_oui.addActionListener(this);
        add(T_non);
        T_non.addActionListener(this);
        add(T_sp);
        T_sp.setEditable(false);
    }

    
    
    public void modify_sp(int oui, int non)
    {
    	int val = 100 - (oui + non);
    	T_sp.setText(""+val);
    }
    
    public void paint(Graphics g) {

 

        int largeur = getWidth();
        int hauteur = getHeight();
        // Largeur defini des barres
        int largeur_barre = 25;

 

        // Valeur des barres
        int oui = 37 * 2;
        int non = 52 * 2;
        int sans_opinion = 11 * 2;

 

        int or_x = largeur / 2 - 100;
        int or_y = hauteur / 2;

 

        int step = 15;

 

        g.setColor(Color.green);
        g.fillRect((or_x), (or_y - oui), largeur_barre, oui);
        g.drawString(oui_s, (or_x), (or_y + 15));
        
        g.setColor(Color.red);
        g.fillRect((or_x + largeur_barre + step), (or_y - non), largeur_barre, non);
        g.drawString(non_s, (or_x + largeur_barre + step), (or_y + 15));
        
        g.setColor(Color.lightGray);
        g.fillRect(or_x + 2 * largeur_barre + 2 * step, (or_y - sans_opinion), largeur_barre, sans_opinion);
        g.drawString(opinion, (or_x + 2 * largeur_barre + 2 * step), (or_y + 15));
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}