
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.applet.*;

public class Conversion extends Applet implements ActionListener{

	TextField euro, franc_suisse, dollar, livre;
	double T1, T2, T3;
	public void init()
	{
		setSize(600,60);
		setLayout(new BorderLayout());
		Panel p1 = new Panel();
		euro = new TextField(10);
		p1.add(new Label("Euros:"));
		p1.add(euro);
		euro.addActionListener(this);
		add(BorderLayout.NORTH, p1);
		
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(1,6));
		franc_suisse = new TextField(10);
		franc_suisse.setEditable(false);
		p2.add(new Label("Francs : "));
		p2.add(franc_suisse);
		dollar = new TextField(10);
		dollar.setEditable(false);
		p2.add(new Label("Dollars : "));
		p2.add(dollar);
		livre = new TextField(10);
		livre = new TextField(10);
		p2.add(new Label("Livres : "));
		p2.add(livre);
		add(BorderLayout.CENTER, p2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
			URL url = new URL(getCodeBase(), "euro.txt");
			InputStream ips = url.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(ips));
			String ligne;
			ligne = in.readLine();			
			T1 = Double.valueOf(ligne);
			//System.out.println(""+taux_1);
			ligne = in.readLine();
			T2 = Double.valueOf(ligne);
			ligne = in.readLine();
			T3 = Double.valueOf(ligne);
			
		} catch ( IOException ex)
		{
			System.out.println(ex.toString());
		}
		System.out.println(""+T1);
		try
		{
			double eur = Double.valueOf(euro.getText());
			franc_suisse.setText(""+((int)(eur*T1*100)/100.0));
			dollar.setText(""+((int)(eur*T2*100)/100.0));
			livre.setText(""+((int)(eur*T3*100)/100.0));
		}
		catch ( Exception ee)
		{
			System.out.println(ee.toString());
		}
		
		// TODO Auto-generated method stub
		
	}

}
