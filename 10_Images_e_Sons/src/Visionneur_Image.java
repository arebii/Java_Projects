
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

 


public class Visionneur_Image extends Applet implements ActionListener{

    TextField nomImage;
    Button b_voirImage;
    List choix;
    
    Image img;
    
    public void init() {
    	
        setSize(500, 500);
        choix = new List();
        add(choix);
        nomImage = new TextField(30);
        add(nomImage);
        nomImage.addActionListener(this);
        b_voirImage = new Button("Voir image");
        add(b_voirImage);
        b_voirImage.addActionListener(this);
    }

    public void paint(Graphics g) {
    if (img!=null) g.drawImage(img,0,0,this);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        img = getImage(getCodeBase(),(nomImage.getText()));
        repaint(); 
    }

}
