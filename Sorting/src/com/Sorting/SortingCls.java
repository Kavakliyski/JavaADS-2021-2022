package com.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SortingCls {

    private static Student[] group = new Student[6];

    public static void createGroup(){
        group[0] = new Student("Petur", 9, 5.25);
        group[1] = new Student("Mitko", 5, 4.26);
        group[2] = new Student("Niki", 7, 3.48);
        group[3] = new Student("Ivan", 6, 5.72);
        group[4] = new Student("Achkata", 11, 2.51);
        group[5] = new Student("Achkata", 10, 3.17);
    }



    public static void main(String[] args) {
        // Arr testing
        createGroup();
        System.out.println("Sorting bt Num" + "\n");
        Arrays.sort(group);
        System.out.println(Arrays.toString(group));

        System.out.println("Sorting by Name" + "\n");
        CompareByName cmpByName = new CompareByName();
        Arrays.sort(group, cmpByName);
        System.out.println(Arrays.toString(group));

        System.out.println("Sorting by Grade" + "\n");
        CompareByGrade cmpByGrade = new CompareByGrade();
        Arrays.sort(group, cmpByGrade);
        System.out.println(Arrays.toString(group));




    }
}
