
public class Jours {

	public static void main(String[] args) {
		
		String jour[]=
			{"lundi","mardi","mercredi","jeudi","vendredi", "samedi","dimanche"};
		
		if (args.length == 0)
		{
			System.out.println("Il manque l'argument");
		}
		else
		{
			System.out.println(jour[Integer.parseInt(args[0])]);
		}
	}

}
