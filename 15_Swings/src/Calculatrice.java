
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("deprecation")
public class Calculatrice extends JFrame implements ActionListener {
	
    JTextField saisie;
    String value1 = "";
    String value2 = "";
    String ope = "";
    String value = "";
    Boolean f = true;

 

    public Calculatrice() {
    	
    	super("Calculatrice");
    	setSize(300,300);
    	
    	ImageIcon image = new ImageIcon("Image10.jpg");
    	
    	setIconImage(image.getImage());
    	
    	JPanel panelPrincipal = (JPanel)getContentPane();
   	
    	panelPrincipal.setLayout(new BorderLayout());
        saisie = new JTextField(10);
        
        saisie.setEditable(false);
        
        JPanel bas = new JPanel();
        
        bas.setLayout(new GridLayout(2, 5,10,10));
        
        for (int i = 0; i < 10; i++) {
            ajouteBouton("" + i, bas);
        }

 
        JPanel operations = new JPanel();
        operations.setLayout(new GridLayout(1, 7, 4, 4));
        ajouteBouton("+", operations);
        ajouteBouton("-", operations);
        ajouteBouton("x", operations);
        ajouteBouton("/", operations);
        ajouteBouton("C", operations);
        ajouteBouton("=", operations);
        ajouteBouton(".", operations);
        
        panelPrincipal.add("North", saisie);
        panelPrincipal.add("Center", bas);
        panelPrincipal.add(BorderLayout.SOUTH, operations);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);

    }


    void ajouteBouton(String S, JPanel p) {
        JButton but = new JButton(S);
        but.addActionListener(this);
        p.add(but);
    }

 

    public String operation(String a, String op, String b) {
        String resultat = "";
        Float a_ = Float.parseFloat(a);
        Float b_ = Float.parseFloat(b);
        switch (op) {
        case "+":
            resultat = "" + (a_ + b_);
            break;
        case "-":
            resultat = "" + (a_ - b_);
            break;
        case "/":
            if (b_ != 0) {
                resultat = "" + (a_ / b_);
            } else {
                resultat = "ERREUR DIVISION PAR 0";
            }
            break;
        case "x":
            resultat = "" + (a_ * b_);
            break;
        }
        return resultat;

 

    }

 

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getActionCommand().charAt(0)) {
        case '=':
            value = operation(value1, ope, value2);
            saisie.setText(value);
            value1 = value;
            value2 = "";
            value = "";
            break;
        case 'C':
            value1 = "";
            value2 = "";
            value = "";
            saisie.setText(value);
            f = false;
            break;
        case '+':
        case '-':
        case 'x':
        case '/':
            ope = arg0.getActionCommand();
            saisie.setText(value1 + ope);
            f = false;
            break;
        default:
            if (f == true) {
                value1 += arg0.getActionCommand();
            } else {
                value2 += arg0.getActionCommand();
            }
            saisie.setText(value1 + ope + value2);
            break;
        }

 

    }
    
    public static void main(String[] args) {
		JFrame frame = new Calculatrice();
		frame.setVisible(true);
	}
}