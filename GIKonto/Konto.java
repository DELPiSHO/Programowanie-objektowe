package com.company;

import java.util.*;
import java.io.Serializable;

class Konto implements Serializable {
    private int stan;
    private List<Integer> zapis = new ArrayList<Integer>();
    Konto() { stan = 0; }
    public void operacja(int ile) throws DebetException, NumberFormatException {
        if (stan + ile >= 0 ) {
            zapis.add(stan);
            stan += ile;
        }
        else throw new DebetException(Math.abs(stan+ile));
    }
    public int dajStan() { return stan ; }

    public int cofnij() {
        if(!zapis.isEmpty()) {
            stan = zapis.get(zapis.size()-1);
            zapis.remove(zapis.size()-1);
            return 0;
        }
        else return 1;
    }
}
