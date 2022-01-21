package combinatorics;

import java.util.ArrayList;

public class Elements<T> {              // <T> zashoto ne znaem tipa na dannite

    private T[] t;

    private ArrayList<T[]> componentsOfElements = new ArrayList<>();

    public Elements(final T[] t) {
        this.t = t;
    }


    private void cleanData() {
        if (!(componentsOfElements.isEmpty()))
            componentsOfElements.clear();
    }


    public ArrayList<T[]> varWithRepetition(int k , int n){
        cleanData();
        CombUtils cu = new CombUtils(6);
        ArrayList<int[]> arrList = cu.generateRep(k, n);
        for (int[] is: arrList) {
            T[] miniArr = (T[]) new Object[k];

            for (int i = 0; i < miniArr.length; i++) {
//                T t1 = t[i];
                miniArr[i] = t[is[i]];
            }
            componentsOfElements.add(miniArr);
        }
        return new ArrayList<T[]>(componentsOfElements);
    }

}
