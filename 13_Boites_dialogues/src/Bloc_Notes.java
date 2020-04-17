import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("deprecation")
public class Bloc_Notes extends Frame implements ActionListener {

	BN_engine ben;
	FileDialog fDial_l, fDial_s;
	String fichier;
	PrintWriter pr;
	MenuItem mi1, mi2, mi3;
	boolean save = true;
	boolean mode = true;
	LoadImage LI;
	FilenameFilter textFilter, imgFilter;
	//
	CardLayout carte;
	Panel text_Images ;
	//
	public Bloc_Notes() {
		super("BLOCK NOT V1.0.0");
		setSize(1250, 800);
		carte = new CardLayout();
		setLayout(new BorderLayout());
		
		addWindowListener(new Fermeture());

		fDial_l = new FileDialog(this, "Choisir", FileDialog.LOAD);
		fDial_s = new FileDialog(this, "Choisir", FileDialog.SAVE);

		MenuItem mi;

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("Fichier");
		mb.add(m1);
		mi1 = new MenuItem("Open");
		mi1.addActionListener(this);
		m1.add(mi1);
		mi2 = new MenuItem("Save");
		mi2.addActionListener(this);
		mi2.setEnabled(false);
		m1.add(mi2);
		mi3 = new MenuItem("Save as");
		mi3.addActionListener(this);
		mi3.setEnabled(false);
		m1.add(mi3);
		m1.addSeparator();
		mi = new MenuItem("Quitter");
		mi.addActionListener(this);
		m1.add(mi);
		Menu m2 = new Menu("Mode");
		mi = new MenuItem("Edition");
		mi.addActionListener(this);
		m2.add(mi);
		mi = new MenuItem("Image");
		mi.addActionListener(this);
		m2.add(mi);
		mb.add(m2);
		text_Images = new Panel();
		text_Images.setLayout(carte);
		ben = new BN_engine();
		text_Images.add("Text", ben);
		ben.init();
		ben.start();
		LI = new LoadImage("D:\\Projets\\Projets_Java\\12_Flots_Octets\\java.gif");
		text_Images.add("Images",LI );
		add("Center", text_Images);
		
	}

	public void affImage(String nomImage) {
		this.removeAll();
		this.add(new LoadImage(nomImage));
		// this.pack();
		this.setVisible(true);
	}

	public void SaveText(String fic) {
		try {
			if (fic.length() != 0) {
				pr = new PrintWriter(new FileOutputStream(fic));
				String st = ben.contenu.getText();
				if (st.length() != 0) {
					pr.write(ben.contenu.getText());
					ben.error.setText("Sauvegarde effectuée");
				}
				pr.close();
			} else {
				ben.error.setText("Aucun fichier selectionné");
			}
		} catch (IOException e) {
			ben.error.setText(e.toString());
		}
	}

	public void browser(String s) {
			
        switch (s) {
        case "Open":
        	if ( mode == true )
        	{
        		ben.setVisible(true);
        		fDial_l.setFile("*.txt;*.java");
        		fDial_l.setVisible(true);
                
                fichier = fDial_l.getDirectory() + "/" + fDial_l.getFile();
                if (fichier != null) {
                	
                    ben.affContent(fichier);
                } else {
                    ben.error.setText("Aucun fichier sélectionné");
                }
                mi2.setEnabled(true);
                mi3.setEnabled(true);
        	}
        	else
        	{
        		//System.out.println(" Mode Image 0 ");
        		//fDial_i.setFilenameFilter(imgFilter);
        		fDial_l.setFile("*.gif;*.jpg;*.png");
        		fDial_l.setVisible(true);
               
                fichier = fDial_l.getDirectory() + "/" + fDial_l.getFile();
                if (fichier != null) {
                	affImage(fichier);
                } 
        	}
        	
            
            break;
        case "SaveAs":
            fDial_s.setVisible(true);
            fichier = fDial_s.getDirectory() + "/" + fDial_s.getFile();
            if (fichier != null) {
                SaveText(fichier);
            } else {
                ben.error.setText("Aucun fichier sélectionné");
            }
            break;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bloc_Notes bn = new Bloc_Notes();
		bn.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getActionCommand()) {

		case "Open":

			if ((ben.contenu.getText().length() != 0) && (save == false)) {
				Boolean rep = MsgBox.affQuest(this,
						"Vous êtes sur le point de quitter, avez vous sauvegardé vos modifications?");
				if (rep == true) {
					browser("Open");
				} else {
					break;
				}

			} else {
				browser("Open");
			}
			save = false;
			break;

		case "Save":
			save = true;
			Boolean rep = MsgBox.affQuest(this, "Etes vous sûr de vouloir sauvegarder?");
			if (rep == true) {
				SaveText(fichier);
			}
			break;

		case "Save as":
			save = true;
			browser("SaveAs");
			break;

		case "Edition":
			carte.first(text_Images);
			mode = true;
			break;
		case "Image":
			carte.last(text_Images);
			mode = false;
			break;
		case "Quitter":
			System.exit(0);
			
			break;
		}
	}
}