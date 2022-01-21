package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static <T> void printT (ArrayList<T[]> temp) {
        for (T[] i : temp) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
//        CombUtils obj = new CombUtils(4);
//        obj.printData();

//        obj.varRep(5, 2);

//        for (int[] i: obj.generateRep(3, 2)) {
//            System.out.println(Arrays.toString(i));
//        }

        String[] words = {"a", "b", "c", "d"};
        Elements<String> wordElements = new Elements<>(words);

        ArrayList<String[]> sent = wordElements.varWithRepetition(4, words.length);

        printT(sent);

    }
}

