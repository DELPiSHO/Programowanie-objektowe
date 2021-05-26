package com.company;

import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        if (o1.znajdzMax(o1.oceny) > o2.znajdzMax(o2.oceny))
            return -1;
        else if (o1.znajdzMax(o1.oceny) == o2.znajdzMax(o2.oceny))
            return 0;
        else
            return 1;

    }

}
