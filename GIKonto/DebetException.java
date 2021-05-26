package com.company;

class DebetException extends Exception {
    static int ile;
    DebetException(int ile) {
        this.ile = ile;
    }

    public static String DebetMessage() {
        return ile + " za duzo";
    }
}
