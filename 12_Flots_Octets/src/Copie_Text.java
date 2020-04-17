
import java.io.*;

public class Copie_Text {
	
	public static void main(String args[]) {
		
		try {
			
			InputStream ips = new FileInputStream(args[0]);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			String ligne;
			int nb_ligne = 0;
			
			while ((ligne = br.readLine()) != null)
			{
				nb_ligne++;
				System.out.println(""+ nb_ligne+ "  "+ligne);
			}
			
			
			System.out.println(" Nb de ligne "+ nb_ligne);
			br.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
}