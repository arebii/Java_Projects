import java.awt.*; // Graphique
import java.applet.*; // Applet

public class Test_BorderLayout extends Applet {
	
	public void init()
	{
		setSize(400,400);
		
		//on déclare le gestionnaire de positionnement
		//setLayout(new BorderLayout());
		setLayout(new BorderLayout(4,4));
		//on place les composants
		//add("Center", new Button("Centre"));
		add(BorderLayout.CENTER, new Button("Centre"));
		add("North", new Button("Nord"));
		add("South", new Button("Sud"));
		add("East", new Button("Est"));
		add("West", new Button("Ouest"));
	}

}
