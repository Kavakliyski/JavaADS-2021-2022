package Algorithms;

import java.util.Comparator;

public class Algos<T>{
    // shabloniran tip ,,T''


    public static<T extends Comparable<T>> void bubbleSort(T arr[], Comparator<T> cmp)  {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n-i-1; j++)
                if (cmp.compare(arr[j], arr[j + 1]) < 0 ){
                    T temp = arr[j];
                    arr[j] = arr [j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static <T extends Comparable<T>> void printArray(T arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // sravnenie na klasove
    public static<T extends Comparable<T>> T minEl(T arr[]) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i].compareTo(min) < 0)
                min = arr[i];
        }

        return min;
    }

    public static<T extends Comparable<T>> T minElByCriteria(T arr[], Comparator<T> cmp) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (cmp.compare(arr[i], min) < 0)
                min = arr[i];
        }

        return min;
    }

}
