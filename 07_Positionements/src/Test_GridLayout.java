import java.awt.*; // Graphique
import java.applet.*; // Applet

public class Test_GridLayout extends Applet{
	
	public void init() {
		setSize(300,200);
		setLayout(new GridLayout(2, 3));
		add(new Button("Pomme"));
		add(new Button("Poire"));
		add(new Button("Abricot"));
		add(new Button("Pêche"));
		add(new Button("Fraise"));
		add(new Button("Ananas"));
		add(new Button("Bidon"));
		}

}
