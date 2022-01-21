package TestStudents;

import Students.CompareByGrade;
import Students.Student;

import java.util.Comparator;

import static Algorithms.Algos.*;

public class TestApp {

    public static void main(String[] args) {
        Integer array[] = {12, 45, 1, -1, 0, 4};
        String[] names = {"Vancho", "Petko", "Georgi"};
        Student group[] = {
                new Student(1, "Ani", 5.45),
                new Student(2, "Bobi", 3.00),
                new Student(3, "Vanko1", 4.89),
                new Student(4, "Pepi", 5.89),
        };

//        printArray(array);
        printArray(group);

        System.out.println("Min element: " + minEl(array));
        System.out.println("Min element: " + minEl(names));
        System.out.println("Min element: " + minEl(group));

        CompareByGrade cbg = new CompareByGrade();
        System.out.println("Min element by grade: " + minElByCriteria(group, cbg));
        System.out.println("Min element in array: " + minElByCriteria(array, Comparator.naturalOrder()));
        System.out.println("Max element in array: " + minElByCriteria(array, Comparator.reverseOrder()));

        bubbleSort(array, Comparator.naturalOrder());
        System.out.println("Sorted array: ");
        printArray(array);

        bubbleSort(group, cbg);
        System.out.println("Sorted by Grade: ");
        printArray(group);
    }

}
