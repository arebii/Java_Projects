
public class Tableau {
	
	public  static int minimum (int tab[])
	{
		int min = 0;
		
		for (int i = 0; i < tab.length ; i++)
		{
			if ( min > tab[i])
			{
				min = tab[i];
			}
		}
		
		return min;
		
	}
	
	public static int maximum (int tab[])
	{
		int max = 0;
		
		for (int i = 0; i < tab.length ; i++)
		{
			if ( max < tab[i])
			{
				max = tab[i];
			}
		}
		return max;
		
	}
	public static double moyenne (int tab[])
	{
		double moy  = 0;
	
		
			
		return moy;
		
	}
	
	public static int[] Tri (int tab[])
	{
		int [] tab_out = new int [tab.length];
		tab_out = tab;
		int tampon = 0;
		boolean permut = false;
		do {
			// hypothèse : le tableau est trié
			permut = false;
			for (int i = 0; i < tab.length-1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (tab_out[i] > tab_out[i + 1]) {
					// s'ils ne le sont pas, on échange leurs positions
					tampon = tab_out[i];
					tab_out[i] = tab_out[i + 1];
					tab_out[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
			
			
		return tab_out;
		
	}
	public static void main(String[] args) {
		
		int tab[];
		
		//int []tab1;
		// déclaration d'un tableau de 5 entiers
		tab = new int[5];
		// Remplissage du tableau
		for (int i = 0; i<5; i++)
		{
			tab[i] = (int)(Math.random()*100);
			System.out.println("Index: "+i+"-->"+tab[i]);
		}
		
		System.out.println("Apres le Tri du tableau");
		// Detection minimum
		
		int m = minimum(tab);
		
		// Detection maximum
		int [] tab1 = Tri(tab);
		
		for (int i = 0; i<5; i++)
		{
			System.out.println("Index: "+i+"-->"+tab1[i]);
		}
		// calcult de somme et moyenne
				
	}
	
}
