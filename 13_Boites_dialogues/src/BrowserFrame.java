
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("deprecation")
public class BrowserFrame extends Frame implements ActionListener {

	BrowserApplet brows;
	MenuItem mi;
	PrintWriter pr;
	FileDialog fDial;

	public BrowserFrame() {
		setSize(600, 600);
		setTitle("My File Explorer");
		fDial = new FileDialog(this, "Choisir", FileDialog.LOAD);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		mi = new MenuItem("Save");
		mi.addActionListener(this);
		m1.add(mi);
		mi = new MenuItem("Save As");
		mi.setActionCommand("Sava_As");
		mi.addActionListener(this);
		m1.add(mi);
		m1.addSeparator();
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);
		addWindowListener(new Fermeture());
		brows = new BrowserApplet();
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

	public void save_As() {
		fDial.setVisible(true);
		String fichier = fDial.getDirectory() + "/" + fDial.getFile();
		save(fichier);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserFrame bf = new BrowserFrame();
		bf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Quitter":
			System.exit(0);
			
		case "Save":
			Boolean rep = MsgBox.affQuest(this, "Etes vous sûr de vouloir sauvegarder?");
			if (rep == true) {
				save(brows.info.getText());
			}
			break;
		
		case "Sava_As":
			save_As();
			break;

		}

	}

}
