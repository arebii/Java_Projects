
public class Epargne2 {

	public static void main(String[] args) {
		
		double capital=10000;
		double taux=1.045;
		int count = 0;
	//traduire l'argument en entier
		
		while(capital < 20000)
		{
			count++;
			capital=capital*taux;
		}
		
		System.out.println("Le capital de 20000 sera atteint au bout de :"+ count + " années");

	}

}
