package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final float pi = 3.14f;
        System.out.println(Person.summ);
        Person.write("Your number is: ");
        Person maks = new Person(180,78.4f);

        maks.say("hi, i'm Maks");

        System.out.println(maks.height);

        Person oleg = new Person();
        oleg.height = 195;
        oleg.weight = 96.9f;


        System.out.println(oleg.height);


        Student Eugene = new Student(189, 84.2f,2);
        System.out.println(Eugene.course);
    }
}
