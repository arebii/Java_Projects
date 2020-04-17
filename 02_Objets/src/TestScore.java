
public class TestScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Score sc1 = new Score();
		Score sc2 = new Score("Patrice");
		sc2.setScore(40);
		sc2.affiche();
		sc2.ajoute(30);
		/*
		 * sc.nom= "Paul"; sc.leScore = 100; sc.scoMax = 1000;
		 */
		sc1.affiche();
		sc2.affiche();
		
		Score2 sc3 = new Score2();
		sc3.affiche();

	}

}
