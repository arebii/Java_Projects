import java.io.*;
public class Copie {
	
	public static void main(String args[]) {
		InputStream in;
		OutputStream out=System.out;
		
		int c=0;
		
		try {
			
			in = new FileInputStream(args[0]);
		
		//if (args.length>1) out=new FileOutputStream(args[1]);
		
		while ((c=in.read())!=-1) 
		{
			out.write(c);
		}
		
		in.close();
		out.close();
		} catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println ("Saisir le nom du fichier à copier");
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
		}
}
