import java.io.*;
import java.net.*;
import java.util.*;

public class My_FTP implements Runnable {
	Socket client; // liaison avec client
	BufferedReader depuisClient; // réception de requête
	PrintWriter versClient; // envoi des réponses
	String path = ".";

	public My_FTP(Socket client) {
		this.client = client;
		try {
			// création des flots de/vers le client
			depuisClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
			versClient = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
			// message d'accueil
			
			 /*versClient.println("Bienvenue sur le serveur FTP.");
			 versClient.println("Entrez dir pour obtenir la liste des fichiers.");
			 versClient.println("Entrez pwd pour afficher le répertoire courant.");
			 versClient.println("Entrez 'cd <rep>' pour obtenir la liste des fichiers du repertoire <rep>.");
			 versClient.println("Entrez 'check name' pour obtenir la nature de <name>");
			 versClient.println("Entrez 'get <file>' pour obtenir le contenu du fichier <file>.");
			 versClient.println("Envoyez une chaîne vide pour fermer la connexion.");*/
			 
		} catch (IOException e) {
			try {
				client.close();
			} catch (IOException ee) {
			}
		}
		// mise en route du processus par appel de la méthode run
		new Thread(this).start(); // ca lance le run
	}

	public void sendClient(String str) {
		File f = new File(str);
		for (int i = 0; i < f.list().length; i++) {
			versClient.println(f.list()[i]);
		}
		versClient.println("EOF");
	}

	public void run() {
		boolean fini = false; // drapeau
		StringTokenizer st;
		try {
			String lue; // la requête
			String rep; // la réponse
			while (!fini) {
				lue = depuisClient.readLine();
				System.out.println("chaine" + lue);

				if (lue == null)
					fini = true;
				else if (lue.contains("dir")) {  // Traitement du dir 
					// path = ".";
					System.out.println(path);
					sendClient(path);
				}

				else if (lue.contains("cd")) {    //Traitement du cd rep 
					st = new StringTokenizer(lue);
					st.nextToken();
					String nomDir = st.nextToken();
					path += ("/" + nomDir);
					System.out.println(path);
					sendClient(path);
				} else if (lue.contains("get")) { //Traitement du get  file 

					try {
						st = new StringTokenizer(lue);
						st.nextToken();
						path += ("/" + st.nextToken());
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
						String ligne;
						while ((ligne = br.readLine()) != null) {
							versClient.println(ligne + "\n");
						}
						versClient.println("EOF");
						br.close();
						path += "/..";
					} catch (Exception e) {
						System.out.println(e.toString());
					}

				} else if (lue.contains("pwd")) {  //Traitement du pwd 
					File f = new File(path);
					versClient.println(f.getCanonicalPath());
					
				} else if (lue.contains("check")) { //Traitement du check name 

					st = new StringTokenizer(lue);
					st.nextToken();
					String nom = st.nextToken();
					String new_path = path + "/" + nom;

					File f = new File(new_path);
					if (f.isFile()) {
						versClient.println("isFile");
					} else {
						versClient.println("isDirectory");
					}

				}

				else {
					fini = true;
				}
			}
		} catch (IOException e) {
			System.out.println("Exception entrée/sortie : " + e.getMessage());
		}
		// fermeture de la connexion
		stop();
	}

	public void stop() {
		try {
			versClient.println("Au revoir !");
			client.close();
		} catch (IOException e) {
			System.out.println("Exception à la fermeture d'une connexion : " + e);
		}
	}
}