import java.awt.*;
import java.applet.*;
import java.io.*;

 

@SuppressWarnings({ "deprecation", "serial" })
public class BN_engine  extends Applet {

 

    TextField error;
    TextArea contenu;
    File f;
    //Image img = null;
    String path;

 

    public void init() {
        setLayout(new BorderLayout());
        //setSize(1100, 800);
        setFont(new Font("TimesRoman", Font.BOLD, 18));

 

        error = new TextField(10);
        contenu = new TextArea();
        
        error.setEditable(false);
        //contenu.setEditable(false);
        
        add("South", error);
        add("Center", contenu);
    }

 

    public boolean isFile(String str) {
        boolean flag = false;
        f = new File(str);
        flag = f.isFile();
        return flag;
    }

 

    public boolean isDir(String str) {
        boolean flag = false;
        f = new File(str);
        flag = f.isDirectory();
        return flag;
    }

 

    public String getPath(String str) {
        String path = "";
        f = new File(str);
        path = f.getAbsolutePath();
        return path;
    }

 

    public int getSize(String str) {
        int val = 0;
        f = new File(str);
        val = (int) f.length();
        return val;
    }

 

    public void affContent(String str) {
        contenu.setText("");
        contenu.setVisible(true);
        try {
            InputStream ips = new FileInputStream(str);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);

 

            String line;
            while ((line = br.readLine()) != null) {
                contenu.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            e.toString();
        }

 

    }

 

}
