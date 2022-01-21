package TestStudents;

import Students.CompareByGrade;
import Students.CompareByName;
import Students.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestStudents {
    private static Student group[] = new Student[5];

    public static void createGroup() {
        group[0] = new Student(1, "Angel", 3.45);
        group[1] = new Student(5, "Boby", 6);
        group[2] = new Student(2, "Gogo", 2);
        group[3] = new Student(3, "Mina", 4.15);
        group[4] = new Student(4, "Ina", 4.25);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arrays
        createGroup();
        System.out.println(Arrays.toString(group));
        System.out.println("Natural sort");
        Arrays.sort(group);
        System.out.println(Arrays.toString(group));

        System.out.println("Sort by name");
        CompareByName cmpByName = new CompareByName();
        Arrays.sort(group, cmpByName);
        System.out.println(Arrays.toString(group));

        System.out.println("Sort by grade");
        CompareByGrade cmpByGrade = new CompareByGrade();
        Arrays.sort(group, cmpByGrade.reversed());
        System.out.println(Arrays.toString(group));

        //ArrayList
        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students, group);
        System.out.println("Natural order");
        Collections.sort(students);
        System.out.println(students);

        System.out.println("By Grade");
        students.sort(cmpByGrade.reversed());
        System.out.println(students);
    }

}
