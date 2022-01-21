package com.Sorting;

import java.util.Comparator;

public class CompareByGrade implements Comparator<Student> {
    @Override
    public int compare(Student std1, Student std2) {
        double diff = std1.getGrade() - std2.getGrade();
        if (Math.abs(diff) < Math.pow(10, -15)) {
            return std1.compareTo(std2);
        }
        if (diff < 0){
            return 1;
        }
        return -1;
    }
}
