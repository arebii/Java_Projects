
public class Score2 extends Score {
	private int nbEssais;

	Score2() {

		super(); // Constructeur de Scoress arguments

		nbEssais = 0;
	}

	Score2(String nom) {

		super(nom); // Constructeur de Score avec argument String nom ..

		nbEssais = 0;
	}
	public void setScore(int sco) {
		super.setScore(sco);
		nbEssais++;
	}

	public int getNbEssais() {
		return nbEssais;
	}
}
