package com.company;

class TestWykazS {
    public static void main(String[] a) throws DuplikatException {
        WykazS ws = new WykazS();

        ws.wstawStudenta(199200, "Weronika");
        ws.wstawStudenta(199204, "Marek");
        ws.wstawStudenta(199205, "Wlad");
        ws.wstawStudenta(189557, "Karolina");
        ws.wstawStudenta(238213, "Eugene");
        try {
            ws.wstawStudenta(189557, "Anton");
        } catch (DuplikatException ex) {
            ex.printStackTrace();
        }

        ws.wstawOcene(199200, 2);
        ws.wstawOcene(199200, 2);
        ws.wstawOcene(199200, 1);
        ws.wstawOcene(199200, 1);
        ws.wstawOcene(199200, 2);

        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);
        ws.wstawOcene(238213, 5);

        ws.wstawOcene(199204, 3);
        ws.wstawOcene(199204, 3);
        ws.wstawOcene(199204, 2);
        ws.wstawOcene(199204, 5);

        ws.wstawOcene(199205, 6);
        ws.wstawOcene(189557, 5);
        System.out.println("WYPISZ WSZYSTKICH: ");
        ws.wypisz();
        System.out.println("WYPISZ INDEX: 238213");
        ws.wypisz(238213);
        System.out.println("Sortowanie wedlug imion");
        ws.sortujA();
        ws.wypisz();
        System.out.println("Sortowanie wedlug ocen");
        ws.sortujS();
        ws.wypisz();
        System.out.println("iterator:");
        ws.wypiszIterator(3);
    }
}