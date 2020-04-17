
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Text_Applet extends Applet {
	
	String nomFichier; 
	
	TextArea zoneTexte = new TextArea();

	public void init() {
		
		
		
		nomFichier = "Copie.java";
		setLayout(new BorderLayout());
		
		add(zoneTexte, BorderLayout.CENTER);
	}

	public void start() {
		try {
			URL url = new URL(getCodeBase(), nomFichier);
//flot associé à l'url
			InputStream ips = url.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(ips));
			String ligne;
			
			while ((ligne = in.readLine()) != null)
			{
					zoneTexte.append(ligne + "\n");
			}
			
			in.close();
		} catch (Exception e) {
			zoneTexte.append("\n" + e.toString() + "\n");
		}
	}
}
