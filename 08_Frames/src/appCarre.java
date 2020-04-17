import java.awt.*;
import java.awt.event.*;

public class appCarre extends Frame implements ActionListener {

	// LeDessin dessin;
	Exo5 dessin;
	
	public appCarre() {
		setSize(600,600);
		MenuItem mi;
		setTitle("H20");
		addWindowListener(new Fermeture());
		
		dessin = new Exo5();
		add(dessin); // placement du dessin 
		dessin.init();
		dessin.start();
//dessin=new LeDessin();
		//add(dessin, BorderLayout.CENTER);
//construction du menu
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
//menu Fichier
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
//item Quitter
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);
//menu Edition
		Menu m2 = new Menu("Edition");
		mb.add(m2);
//item Cercles
		mi = new MenuItem("Cercles");
		mi.addActionListener(this);
		m2.add(mi);
//item Carrés
		mi = new MenuItem("Carrés");
		mi.addActionListener(this);
		m2.add(mi);
//séparateur
		m2.addSeparator();
//item Recalculer
		mi = new MenuItem("Recalculer");
		mi.setActionCommand("Changer");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appCarre ap = new appCarre();
		ap.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Quitter"))
		{
			System.exit(0);
		} 
		else if (e.getActionCommand().equals("Cercles"))
		{
			dessin.modeCercle();
		}
		
		else if (e.getActionCommand().equals("Carrés"))
		{
			dessin.modeCarre();
		}
		
		
		
	}
	
	
	

}