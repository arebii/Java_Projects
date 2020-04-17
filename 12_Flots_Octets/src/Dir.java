import java.io.*;

public class Dir {
	public static void main(String[] args) {
		
		File f = new File("."); // On se place dans le repértoire courant ( Repértoire du projet)
		
		System.out.println(f.getAbsolutePath());
		
		String[] liste = f.list();
		
		for (int i = 0; i < liste.length; i++) 
		{
			System.out.println(liste[i]);
		}
		
		for (int i = 0; i < liste.length; i++) {
			
			File ff = new File(liste[i]);
			
			if (ff.isDirectory())
				
				System.out.println("Dossier \t" + liste[i]);
			
			else
				
				System.out.println("" + ff.length() + " \t" + liste[i]);
		}
	}
}