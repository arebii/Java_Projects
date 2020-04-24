import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * classe représentant un JPanel contenant un tableau dont les 
 * données se trouvent dans un fichier csv 
 * - texte, un enregistrement par ligne
 * - champs séparés par des virgules,
 * - la première ligne donne les noms des champs
 */
public class DataFileTable extends JPanel {

 DataFileTableModel model;    // le modèle de remplissage
 TableCloser tc;
 
 /**
  * constructeur : le nom du fichier de données est passé en
  * paramètre
  */
 public DataFileTable(String dataFilePath) {
  tc=new TableCloser();
  JTable table;                // le tableau
  //fonte
  Font f=new Font("SanSerif",Font.PLAIN,24);
  setFont(f);
  //gestionnaire de positionnement
  setLayout(new BorderLayout());
  //construction du modèle de remplissage à partir du fichier
  model = new DataFileTableModel(dataFilePath);
  //création du tableau
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
  * méthode principale du programme
  * création et affichage de la fenêtre
  */
 public static void main(String args[]) {
  //la fenêtre du programme
  JFrame fen=new JFrame("Table");
  //le tableau
  DataFileTable tablo;
  String nomFichier="datas.txt";
  if (args.length>0) nomFichier=args[0];
  tablo=new DataFileTable(nomFichier);
  //configuration de la fenêtre
  fen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  fen.setForeground(Color.black);
  fen.setBackground(Color.lightGray);
  fen.getContentPane().add(tablo,"Center");
  fen.setSize(tablo.getPreferredSize());
  //affichage
  fen.setVisible(true);
  //écouteur pour fermeture
  fen.addWindowListener(tablo.tc);
 }

 /**
  * classe gérant la fermeture de la fenêtre
  */
 class TableCloser extends WindowAdapter {

  public void windowClosing(WindowEvent e) {
   model.saveVectors();
   Window win=e.getWindow();
   //effacer la fenêtre
   win.setVisible(false);
   //terminer le programme
   System.exit(0);
  }
 
 }

}


