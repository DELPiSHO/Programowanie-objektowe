package com.company;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private int nr;
    private String imie;
    ArrayList<Integer> oceny = new ArrayList<>();

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Student(int nr, String imie) {
        this.nr = nr;
        this.imie = imie;
    }

    public String toString() {
        return getNr() + " " + getImie() + " " + oceny;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return imie.compareTo(o.getImie());
    }

    public int znajdzMax(ArrayList<Integer> oceny) {
        int max = oceny.get(0);
        for (int i = 1; i < oceny.size(); i++) {
            if (oceny.get(i) > max)
                max = oceny.get(i);
        }
        return max;
    }

}
