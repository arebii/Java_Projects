
public class Jeu21 {
	public static void main(String args[]) {
		
		double d;
		
		int tirage;
		
		Score2 pierre = new Score2("Pierre");
		
		while (pierre.getScore() < 21) {
			//D = new Double(6 * Math.random() + 1);
			d = (6 * Math.random()) + 1;
			tirage = (int)d;
			pierre.ajoute(tirage);
			pierre.affiche();
		}
		System.out.println("Pierre a gagné en " + pierre.getNbEssais() + " coups.");
	}
}
