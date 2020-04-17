
public class Exo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int S = 0;
		int i = 0;
		/*
		for (i = 0; i <=100; i+=5)
		{
			S += i;
			System.out.println("I: " + i);
		}
		*/
		while (i <= 100)
		{
			S += i;
			System.out.println("I: " + i);
			i+= 5;
		}

		System.out.println("La somme vaut: " + S);
	}

}
