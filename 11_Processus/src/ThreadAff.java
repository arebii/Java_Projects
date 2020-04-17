
public class ThreadAff extends Thread {
	
	public ThreadAff(String nom) {
		super(nom);
	}

//afficher 10 fois le nom
	public void run() {
		for (int i = 0; i < 10; i++) {
//effectue la tâche prévue
			System.out.println("Je suis le processus " + getName());
//passe la main au processus suivant
			Thread.yield();
		}
	}
}