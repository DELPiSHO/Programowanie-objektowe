package com.company;

public class LiczbaU {
    int calosci;
    Ulamek czescU;

    public LiczbaU(int calosci, Ulamek czescU) {
        this.calosci = calosci;
        this.czescU = czescU;
    }

    void mnozPrzez(LiczbaU l) {
        this.calosci = ((((this.calosci * this.czescU.mianownik) + this.czescU.licznik))
                * (((l.calosci * l.czescU.mianownik) + l.czescU.licznik)) / (this.czescU.mianownik * l.czescU.mianownik));

        this.czescU.licznik = ((((this.calosci * this.czescU.mianownik) + this.czescU.licznik))
                * (((l.calosci * l.czescU.mianownik) + l.czescU.licznik)) % (this.czescU.mianownik*this.czescU.licznik));

        this.czescU.mianownik *= l.czescU.mianownik;

    }

    void mnozPrzez(int i) {
        this.calosci *= i;
    }
}
