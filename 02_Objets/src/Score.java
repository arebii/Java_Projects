
public class Score {

	String nom;
	private int leScore;
	int scoMax;

	Score() {
		nom = "inconnu";
		leScore = 0;
		scoMax = 100;
	}

	Score(String nom) {
		this.nom = nom;
		leScore = 0;
		scoMax = 100;
	}

	// méthode de lecture
	public int getScore() {
		return leScore;
	}

	// méthode d'écriture
	public void setScore(int sco) {
		if (sco > scoMax)
			leScore = scoMax;
		else if (sco < 0)
			leScore = 0;
		else
			leScore = sco;
	}
	
	public void ajoute(int points) {
		setScore(leScore+points);
		}

	void affiche() {
		System.out.println(nom + " : " + leScore);
	}

}
