import java.io.*;
import java.net.*;

public class ServHeure {
	
	static int port;

	public static void main(String args[]) {
		
		ServerSocket serveur;
		
//définition du port
		try {
			port = Integer.parseInt(args[0]);
			
		} catch (Exception e) {
			
			port = 1234; // valeur par défaut
		}
//installation
		try {
			serveur = new ServerSocket(port);
			System.out.println(" Serveur Heure en cours sur le port "  + port );
			while (true) {
//création de nouvelles connexions
				Socket s = serveur.accept();
				new MaConnexion(s);   // Définition du service à rendre au client
			}
			
		} catch (IOException e) {
			System.out.println("Erreur à la creation d'un objet Socket : " + e.getMessage());
			System.exit(1);
		}
	}
}
