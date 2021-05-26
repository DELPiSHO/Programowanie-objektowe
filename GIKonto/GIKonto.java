package com.company;

import java .awt.* ;
import java.awt.event.* ;
import javax.swing.*;
import java.util.*;
import java.io.Serializable;
import java.io.*;

public class GIKonto extends JFrame {
    JTextField stan = new JTextField(20);
    JTextField kwota = new JTextField(10);
    JTextField rezultat = new JTextField(20);
    Konto konto = new Konto();
    JButton dzialanie = new JButton("Wplata/Wyplata");
    JButton odblokuj = new JButton("Odblokuj");
    JButton cofnij = new JButton("Cofnij");
    JButton zapisz = new JButton("Zapisz");
    JButton wczytaj = new JButton("Wczytaj");

    GIKonto() {
        setTitle("Konto");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4,2,10,10));
        cp.add(new JLabel("Stan"));
        cp.add(stan);
        stan.setText(Integer.toString(konto.dajStan()));
        cp.add(new JLabel(""));
        cp.add(kwota);
        cp.add(dzialanie);
        dzialanie.addActionListener( new Operacja());
        cp.add(rezultat);
        cp.add(odblokuj);
        odblokuj.addActionListener( new Blokowanie());
        cp.add(cofnij);
        cofnij.addActionListener(new Cofnij());
        cp.add(new JLabel(""));
        cp.add(zapisz);
        zapisz.addActionListener(new Zapisz());
        cp.add(wczytaj);
        wczytaj.addActionListener(new Wczytaj());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    int dajLiczbe(JTextField tf) throws NumberFormatException {
        return Integer.parseInt(tf.getText());
    }

    public static void main(String[] arg) {
        JFrame gi = new GIKonto();
        gi.setSize(500,300);
    }

    //sleva ot wpl/wypl
    class Operacja implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                konto.operacja(dajLiczbe(kwota));
                rezultat.setText("OK");
                stan.setText(Integer.toString(konto.dajStan()));
            } catch(DebetException de) {
                rezultat.setText(DebetException.DebetMessage());
            } catch(NumberFormatException nfe){
                rezultat.setText("Niepoprawne dane");
            }
            dzialanie.setEnabled(false);
            kwota.setEnabled(false);
        }
    }

    class Blokowanie implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dzialanie.setEnabled(true);
            kwota.setEnabled(true);
            kwota.setText("");
            rezultat.setText("");
        }
    }

    class Cofnij implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(konto.cofnij() == 0) {
                stan.setText(Integer.toString(konto.dajStan()));
                rezultat.setText("Cofnieto");
            }
            else {
                rezultat.setText("Nie mozna cofnac");
            }
        }
    }

    class Zapisz implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                FileOutputStream fOut = new FileOutputStream("ObKonto");
                ObjectOutputStream os = new ObjectOutputStream(fOut);
                os.writeObject(konto);
                fOut.close();
                rezultat.setText("Zapisano");
            } catch (IOException ex){}
        }
    }

    class Wczytaj implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                ObjectInputStream is = new ObjectInputStream(new FileInputStream("ObKonto"));
                konto = (Konto)is.readObject();
                is.close();
                rezultat.setText("Wczytano");
                stan.setText(Integer.toString(konto.dajStan()));
            } catch (IOException ex){
            }catch (ClassNotFoundException nfe){}
        }
    }
}

