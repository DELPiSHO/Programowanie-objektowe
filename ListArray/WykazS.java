package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class WykazS {
    ArrayList<Student> wykaz = new ArrayList<>();

    void wstawStudenta(int nr, String imie) throws DuplikatException {
        for (Student s : wykaz) {
            if (s.getNr() == nr) {
                System.out.println("Zduplikowany numer: " + nr);
                throw new DuplikatException("duplikat");
            }
        }
        wykaz.add(new Student(nr, imie));
    }

    void wstawOcene(int nr, int ocena) {
        Student s = wykaz.get(zwroc(nr));
        s.oceny.add(ocena);

    }

    int zwroc(int nr) {
        for (int i = 0; i < wykaz.size(); i++) {
            if (nr == wykaz.get(i).getNr())
                return i;
        }
        return 0;
    }

    void wypisz(int nr) {
        System.out.println(wykaz.get(zwroc(nr)));
    }

    void wypiszIterator(int nr) {

        for (Iterator<Student> iter = wykaz.iterator(); iter.hasNext();) {
            Student s = iter.next();
            Collections.sort(s.oceny); // najnizsza ocene przestawia na koniec i sprawdza czy jest >= nr
            if (s.oceny.get(0) >= nr) {
                System.out.println(s);
            }
        }

    }

    void wypisz() {
        for (Student s : wykaz) {
            System.out.println(s);
        }
    }

    void sortujA() {
        Collections.sort(wykaz);
    }

    void sortujS() {
        Collections.sort(wykaz, new StudentMarkComparator());
    }

}
