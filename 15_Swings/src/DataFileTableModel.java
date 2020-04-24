import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class DataFileTableModel extends AbstractTableModel {
 protected Vector data;            //données
 protected Vector columnNames ;    //noms de colonnes
 protected String datafile;        //nom du fichier de données
 protected boolean modified;       //indicateur de modifications
 
 /**
  * constructeur : on récupère le nom du fichier
  * puis on initialise les deux Vectors en lisant le fichier
  */
 public DataFileTableModel(String f) {
  datafile = f;
  initVectors();
 }

 /**
  * lecture du fichier de données
  */
 public void initVectors() {
  modified=false;
  String ligne;
  data=new Vector();
  columnNames=new Vector();
  try {
   FileInputStream fin=new FileInputStream(datafile);
   BufferedReader br=new BufferedReader(new InputStreamReader(fin));
   // lecture des noms de colonnes (1ère ligne)
   ligne=br.readLine();
   StringTokenizer st1=new StringTokenizer(ligne, ",");
   while(st1.hasMoreTokens())
    columnNames.addElement(st1.nextToken());
   // lecture des données
   while ((ligne=br.readLine()) != null) {
    StringTokenizer st2=new StringTokenizer(ligne, ",");
    while(st2.hasMoreTokens())
     data.addElement(st2.nextToken());
    }
   br.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 /**
  * sauvegarde des modifications
  */
 public void saveVectors() {
  if (modified) saveAs(datafile);
 }
 
 /**
  * sauvegarde des données dans un fichier
  */
 public void saveAs(String nomFichier) {
  try {
   OutputStream fs=new FileOutputStream(nomFichier);
   PrintWriter out=new PrintWriter(fs);
   //noms des colonnes
   String ligne="";
   for (int i=0; i<columnNames.size()-1;i++) 
    ligne=ligne+getColumnName(i)+",";
   ligne=ligne+getColumnName(columnNames.size()-1);
   out.println(ligne);
   //données
   for (int i=0; i<getRowCount(); i++) {
    ligne="";
    for (int j=0; j<columnNames.size()-1;j++)
     ligne=ligne+(String)getValueAt(i,j)+",";
    ligne=ligne+(String)getValueAt(i,columnNames.size()-1);
    out.println(ligne);
   }
   out.close();
  } catch (Exception e) {
   e.printStackTrace();
  } 
 }
 
 /**
  * nombre de lignes
  */
 public int getRowCount() {
  return data.size()/getColumnCount();
 }

 /**
  * nombre de colonnes
  */
 public int getColumnCount() {
  return columnNames.size();
 }

 /**
  * noms des colonnes
  */
 public String getColumnName(int columnIndex) {
  String colName="";
  if (columnIndex <= getColumnCount())
   colName=(String)columnNames.elementAt(columnIndex);
  return colName;
 }

 /**
  * type de contenu d'une colonne : ici il s'agit toujours de chaînes
  * de caractères.
  */
 public Class getColumnClass(int columnIndex){
  return String.class;
 }

 /**
  * possibilité d'édition des données
  */
 public boolean isCellEditable(int rowIndex, int columnIndex) {
  return true;
 }

 /**
  * contenu d'une cellule
  */
 public Object getValueAt(int rowIndex, int columnIndex) {
  return (String)data.elementAt(
           (rowIndex*getColumnCount())+columnIndex);
 }

 /**
  * changement du contenu d'une cellule
  */
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
  data.setElementAt(aValue, (rowIndex*getColumnCount())+columnIndex); 
  modified=true;
 }

}

