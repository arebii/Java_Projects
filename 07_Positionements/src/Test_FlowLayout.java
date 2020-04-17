import java.awt.*; // Graphique
import java.applet.*; // Applet

 

public class Test_FlowLayout extends Applet {
	
	public void init()
	{
		setSize(400,400);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new Button("Pomme"));
		add(new Button("Poire"));
		add(new Button("Abricot"));
		add(new Button("Pêche"));
		add(new Button("Fraise"));
	}

}
