
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

 


public class Visionneur_Image extends Applet implements ActionListener{

    
    List choix;
    
    Image img;
    
    public void init() {
    	
        setSize(500, 500);
        setLayout(new BorderLayout());
        choix = new List();
        add(BorderLayout.WEST, choix);
        choix.addActionListener(this); 
       
    }

    public void paint(Graphics g) {
    if (img!=null) g.drawImage(img,0,0,this);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //img = getImage(getCodeBase(),(nomImage.getText()));
        repaint(); 
    }

}
