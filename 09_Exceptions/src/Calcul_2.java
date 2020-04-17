import java.awt.*;
import java.awt.event.*;
import java.util.*;

 

public class Calcul_2 extends Frame implements ActionListener {

    TextField tf_operation;
    TextField resultat;

    public Calcul_2() {
        setSize(400, 400);
        setLayout(new GridLayout(2, 1));
        addWindowListener(new Fermeture());

        tf_operation = new TextField(20);
        tf_operation.addActionListener(this);
        add(tf_operation);

        resultat = new TextField(20);
        resultat.setEditable(false);
        add(resultat);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	Calcul_2 cal = new Calcul_2();
        cal.setVisible(true);
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
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String calcul = tf_operation.getText();
        System.out.println(calcul);
        StringTokenizer st = new StringTokenizer(calcul, "+-/x", true);
        String a, op, b;
        a = st.nextToken();
        while (st.hasMoreTokens()) {
            try {            
                op = st.nextToken();
                b = st.nextToken();
                resultat.setText(operation(a, op, b));
                a = operation(a, op, b);
                op = "";
                b = "";
            } catch (NoSuchElementException r0) {
                System.out.println("Il manque un parametre");
            } catch (NumberFormatException r1) {
                System.out.println("Mauvais format de parametre");
            } catch (Exception er) {
                System.out.println(er.toString());
            }
        }
    }
}