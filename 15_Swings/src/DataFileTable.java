import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * classe repr�sentant un JPanel contenant un tableau dont les 
 * donn�es se trouvent dans un fichier csv 
 * - texte, un enregistrement par ligne
 * - champs s�par�s par des virgules,
 * - la premi�re ligne donne les noms des champs
 */
public class DataFileTable extends JPanel {

 DataFileTableModel model;    // le mod�le de remplissage
 TableCloser tc;
 
 /**
  * constructeur : le nom du fichier de donn�es est pass� en
  * param�tre
  */
 public DataFileTable(String dataFilePath) {
  tc=new TableCloser();
  JTable table;                // le tableau
  //fonte
  Font f=new Font("SanSerif",Font.PLAIN,24);
  setFont(f);
  //gestionnaire de positionnement
  setLayout(new BorderLayout());
  //construction du mod�le de remplissage � partir du fichier
  model = new DataFileTableModel(dataFilePath);
  //cr�ation du tableau
  table=new JTable();
  table.setModel(model);
  table.createDefaultColumnsFromModel();
  //scroller
  JScrollPane scrollpane=new JScrollPane(table);
  add(scrollpane);
 }

 /**
  * dimensions du tableau
  */
 public Dimension getPreferredSize() {
  return new Dimension(400, 300);
 }

 /**
  * m�thode principale du programme
  * cr�ation et affichage de la fen�tre
  */
 public static void main(String args[]) {
  //la fen�tre du programme
  JFrame fen=new JFrame("Table");
  //le tableau
  DataFileTable tablo;
  String nomFichier="datas.txt";
  if (args.length>0) nomFichier=args[0];
  tablo=new DataFileTable(nomFichier);
  //configuration de la fen�tre
  fen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  fen.setForeground(Color.black);
  fen.setBackground(Color.lightGray);
  fen.getContentPane().add(tablo,"Center");
  fen.setSize(tablo.getPreferredSize());
  //affichage
  fen.setVisible(true);
  //�couteur pour fermeture
  fen.addWindowListener(tablo.tc);
 }

 /**
  * classe g�rant la fermeture de la fen�tre
  */
 class TableCloser extends WindowAdapter {

  public void windowClosing(WindowEvent e) {
   model.saveVectors();
   Window win=e.getWindow();
   //effacer la fen�tre
   win.setVisible(false);
   //terminer le programme
   System.exit(0);
  }
 
 }

}


