package com.company;

public class App {
    public static void main(String[] args) {
        Ulamek ulamek = new Ulamek(1, 2);
        LiczbaU liczbaU = new LiczbaU(2, ulamek);
        liczbaU.mnozPrzez(liczbaU);
        System.out.println("Calosc: " + liczbaU.calosci + " Ulamek: " + ulamek.licznik + "/" + ulamek.mianownik);
        liczbaU.mnozPrzez(5);
        System.out.println("Calosc: " + liczbaU.calosci + " Ulamek: " + ulamek.licznik + "/" + ulamek.mianownik);
    }

}
