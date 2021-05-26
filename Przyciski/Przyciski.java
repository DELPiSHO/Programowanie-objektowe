package com.company;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

@SuppressWarnings("serial")
public class Przyciski extends JFrame {
    JTextField t = new JTextField(30);
    JLabel yellow = new JLabel("0");
    JLabel licznik = new JLabel("0");
    JButton b1 = new JButton("przycisk 1");
    JButton b2 = new JButton("przycisk 2") ;
    JButton b3 = new JButton("przycisk 3") ;
    JButton b4 = new JButton("przycisk 4") ;
    JButton b0 = new JButton("Wyzeruj");
    private int count = 0;
    private int yellowButtons = 0;
    boolean z1 = true;
    boolean z2 = true;
    boolean z3 = true;
    boolean z4 = true;

    Przyciski(){
        setTitle("Przyciski");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout()) ;
        cp.add(b1) ;
        cp.add(b2) ;
        cp.add(b3) ;
        cp.add(b4) ;
        cp.add(t) ;
        cp.add(licznik);
        licznik.setToolTipText("Licznik klikow");
        cp.add(yellow);
        yellow.setToolTipText("Licznik zoltych przyciskow");
        cp.add(b0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200) ;
        setVisible(true) ;
        b1.addActionListener( new B1());
        b2.addActionListener( new B2());
        b3.addActionListener( new B3());
        b4.addActionListener( new B4());
        b4.addActionListener( new B0());
        b1.setBackground(Color.green);
        b2.setBackground(Color.green);
        b3.setBackground(Color.green);
        b4.setBackground(Color.green);
    }

    class B1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (yellowButtons % 2 == 0 && yellowButtons > 0 && z1) {
                b1.setEnabled(false);
            } else if (z1) {
                t.setText("Kolor zostal zmieniony na: ZOLTY");
                yellow.setText(++yellowButtons + "");
                b1.setBackground(Color.yellow);
                licznik.setText(++count + "");
                z1 = false;
                b1.setEnabled(true);
            }

            else {
                yellow.setText(--yellowButtons + "");
                t.setText("Kolor zostal zmieniony na: ZIELONY");
                b1.setBackground(Color.green);
                z1 = true;
                b1.setEnabled(true);
            }
        }
    }

    class B2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (yellowButtons % 2 == 0 && yellowButtons > 0 && z2) {
                b2.setEnabled(false);
            } else if (z2) {
                t.setText("Kolor zostal zmieniony na: ZOLTY");
                yellow.setText(++yellowButtons + "");
                b2.setBackground(Color.yellow);
                licznik.setText(++count + "");
                z2 = false;
                b2.setEnabled(true);
            }

            else {
                yellow.setText(--yellowButtons + "");
                t.setText("Kolor zostal zmieniony na: ZIELONY");
                b2.setBackground(Color.green);
                z2 = true;
                b2.setEnabled(true);
            }
        }
    }
    class B3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (yellowButtons % 2 == 0 && yellowButtons > 0 && z3) {
                b3.setEnabled(false);
            } else if (z3) {
                t.setText("Kolor zostal zmieniony na: ZOLTY");
                yellow.setText(++yellowButtons + "");
                b3.setBackground(Color.yellow);
                licznik.setText(++count + "");
                z3 = false;
                b3.setEnabled(true);
            }

            else {
                yellow.setText(--yellowButtons + "");
                t.setText("Kolor zostal zmieniony na: ZIELONY");
                b3.setBackground(Color.green);
                z3 = true;
                b3.setEnabled(true);
            }
        }
    }

    class B4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (yellowButtons % 2 == 0 && yellowButtons > 0 && z4) {
                b4.setEnabled(false);
            } else if (z4) {
                t.setText("Kolor zostal zmieniony na: ZOLTY");
                yellow.setText(++yellowButtons + "");
                b4.setBackground(Color.yellow);
                licznik.setText(++count + "");
                z4 = false;
                b4.setEnabled(true);
            }

            else {
                yellow.setText(--yellowButtons + "");
                t.setText("Kolor zostal zmieniony na: ZIELONY");
                b4.setBackground(Color.green);
                z4 = true;
                b4.setEnabled(true);
            }
        }
    }

    class B0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            count = 0;
            licznik.setText(count + "");
        }
    }

    public static void main(String[] arg){
        JFrame f = new Przyciski() ;
    }
}
