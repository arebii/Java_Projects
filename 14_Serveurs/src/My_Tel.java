
import java.io.*;
import java.net.*;
import java.util.*;

public class My_Tel implements Runnable {
	
	Socket client; 						// liaison avec client
	BufferedReader depuisClient; 		// réception de requête
	PrintWriter versClient; 			// envoi des réponses
	Hashtable dico;
	
	

	public My_Tel(Socket client) {
		this.client = client;
		
		dico = new Hashtable();
		remplirDico();
		
		try {
// création des flots de/vers le client
			depuisClient = new BufferedReader(new InputStreamReader(client.getInputStream()));	
			versClient = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
// message d'accueil
			versClient.println("Bienvenue sur le serveur de telephone.");
			versClient.println("Entrez un nom  pour obtenir son numero de telephone.");
			versClient.println("Envoyez une chaîne vide pour fermer la connexion.");
			
			cleanBuffer();
			
		} catch (IOException e) {
			try {
				client.close();
			} catch (IOException ee) {
			}
		}
//mise en route du processus par appel de la méthode run
		new Thread(this).start();
	}
	
	public void cleanBuffer()
	{	
		int c  = 0;
		try
		{
			for (int i = 0; i < 21;  i++)
			{
				c = depuisClient.read();
				//System.out.println("C : "+ i + " "  +  c);
				
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void remplirDico()
	{
		StringTokenizer st ;
		String nom = "";
		String tel = "";
		String ligne = "";
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("annuaire.txt")));
			while ((ligne = br.readLine()) != null)
			{
				System.out.println(ligne);
				st = new StringTokenizer(ligne, ":");
				nom = st.nextToken();
				tel = st.nextToken();
				dico.put(nom, tel);
			}
			br.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}

	public void run() {
		boolean fini = false; // drapeau
		try {
			String lue; // la requête
			String rep; // la réponse
			while (!fini) {
				lue = depuisClient.readLine();
				System.out.println(lue);
				if (lue.isEmpty())
					fini = true;
				
				else 
				
				{
					rep = (String)dico.get(lue);
					System.out.println("Tel :"+ rep);
					if ( rep != null)
					{
						versClient.println(rep);
					}
					else
					{
						versClient.println("Nom inconnu ");
					}
					
					
				}
			}
		} catch (IOException e) {
			System.out.println("Exception entrée/sortie : " + e.getMessage());
		}
//fermeture de la connexion
		stop();
	}

	public void stop() {
		try {
			versClient.println("Au revoir !");
			client.close();   				// fermeture de la connexion avec le Client
		} catch (IOException e) {
			System.out.println("Exception à la fermeture d'une connexion : " + e);
		}
	}
}