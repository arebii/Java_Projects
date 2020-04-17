
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("deprecation")
public class BrowserFrame extends Frame implements ActionListener {

	Browser brows;
	MenuItem mi;
	PrintWriter pr;
	

	public BrowserFrame() {
		setSize(600, 600);
		setTitle("File Explorer");

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
//menu Fichier
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		mi = new MenuItem("Save");
		mi.addActionListener(this);
		m1.add(mi);
		mi = new MenuItem("Save As");
		mi.addActionListener(this);
		m1.add(mi);
		m1.addSeparator();
//item Quitter
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);
//menu Edition
		Menu m2 = new Menu("Mode");
		mb.add(m2);
		mi = new MenuItem("Edition");
		mi.addActionListener(this);
		m2.add(mi);
//item Cercles
		//item Carrés
		
		addWindowListener(new Fermeture());
		brows = new Browser();
		add(brows);
		brows.init();
		brows.start();

	}

	public void save(String file_name) {
		try {
			pr = new PrintWriter(new FileOutputStream(file_name));
			pr.write(brows.contenu.getText());
			pr.close();
		} catch (IOException e) {
			brows.error.setText(e.toString());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserFrame bf = new BrowserFrame();
		bf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Quitter")) {
			System.exit(0);
		} else {
			if (e.getActionCommand().equals("Save")) {
				save(brows.info.getText());

			}
		}

	}

}
