
public class ajoute {
	public static void main(String[] args) {
		try {
			double d1 = Double.valueOf(args[0]).doubleValue();
			double d2 = Double.valueOf(args[1]).doubleValue();
			double r = d1 + d2;
			System.out.println(d1 + "+" + d2 + "=" + r);
		} catch( ArrayIndexOutOfBoundsException ee)
		{
			System.out.println("Erreur :");
			System.out.println("Il manque les arguments");
			System.out.println("Fin erreur.");
		}
		catch (NumberFormatException er)
		{
			System.out.println("Erreur :");
			System.out.println("Argument non convertible");
			System.out.println("Fin erreur.");
		}
		catch (Exception e) {
			System.out.println("Erreur :");
			System.out.println(e.toString());
			System.out.println("Fin erreur.");
		}
		finally {
			System.out.println("Au revoir");
		}
	}
}