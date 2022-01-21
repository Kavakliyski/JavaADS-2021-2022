/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Niky
 */
public class JavaTreеs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        set.add(3);
        if (set.contains(3)) {/* do smth */
        }
        set.remove(3);
        for (Integer element : set) {
            System.out.println(element);
        }
        System.out.println("Size: " + set.size()); // Number of elements in set

        TreeSet<String> strSet = new TreeSet<>();
        strSet.add("Pesho");
        strSet.add("Gosho");
        strSet.add("Maria");
        strSet.add("Maria");

        if (strSet.contains("Iavn")) {
            /* do smth */
        }

        strSet.remove("Gosho");
        for (String element : strSet) {
            System.out.println(element);
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Ivan", 22);
        map.put("Maria", 21);
        map.put("Georgi", 23);

        System.out.println(map.get("Ivan"));

        if (map.containsKey("Ivan")) {
            /* ... */
        }
        map.remove("Ivan");

    }

}
