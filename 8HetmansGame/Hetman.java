package com.company;

public class Hetman {

    private static boolean dia_r[] = new boolean[256];
    private static boolean dia_l[] = new boolean[256];
    private static boolean col[] = new boolean[8];       // tablica z zajętymi kolumnami
    private static boolean chart[][] = new boolean[8][8];// tablica z ustawieniami hetmanów
    private static byte found = 0;                       // licznik znalezionych pozycji

    @SuppressWarnings("unchecked")
    private static void add_hetman(int row) {
        for (int i=0; i<8; i++) {
            if (!((col[i]) || (dia_r[i-row+128]) || (dia_l[row+i+128]))) {
                dia_r[i-row+128] = true;     // dodaj przekątne
                dia_l[row+i+128] = true;
                col[i] = true;               // dodaj kolumnę
                chart[i][row] = true;        // postaw hetmana w tablicy
                if (row<7) {
                    add_hetman(row+1);       // analizuj nastepny wiersz (tylko jesli nie jestesmy juz w ostatnim)
                }
                else {                       // to jest ostatni hetman - zapisz wynik
                    found++;
                    printCombination();
                }
// po wyjsciu z procedury rekurencyjnej (add_hetman(row+1)) usun hetmana i szukaj dla niego nastepnego pola
                dia_r[i-row+128] = false;
                dia_l[row+i+128] = false;
                col[i] = false;
                chart[i][row] = false;
            }
        }
    }

    public static void printCombination() {
        System.out.println("kombinacja: " + found);
        System.out.println("  ABCDEFGH");
        System.out.println("");
        for (int y=7; y>=0; y--) {
            System.out.print(y+1 + " ");
            for (int x=0; x<8; x++) {
                if (chart[x][y]) {
                    System.out.print("H");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     *
     */
    public static void main(String[] args) {
        add_hetman(0);             // postaw pierwszego hetmana
    }

}