package com.Sorting;

import java.util.Comparator;

public class CompareByName implements Comparator<Student> {

    @Override
    public int compare(Student std1, Student std2) {
        if (std1.getName().equals(std2.getName())){
            return std1.compareTo(std2);
        }

        return std1.getName().compareTo(std2.getName());
    }
}
