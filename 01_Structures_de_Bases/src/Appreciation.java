
public class Appreciation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0)
		{
			System.out.println("Il manque l'argument");
		}
		else
		{
			int note = Integer.parseInt(args[0]);
			switch (note) {
			case 0: 
			case 1: 
			case 2:
			System.out.println("Très insuffisant.");
			break;
			case 3: 
			case 4:
			System.out.println("Insuffisant.");
			break;
			case 5: 
			case 6:
			System.out.println("Moyen.");
			break;
			case 7: 
			case 8:
			System.out.println("Bien.");
			break;
			case 9: 
			case 10:
			System.out.println("Très bien.");
			break;
			default :
			System.out.println("Note impossible.");
			}
		}
	}

}
