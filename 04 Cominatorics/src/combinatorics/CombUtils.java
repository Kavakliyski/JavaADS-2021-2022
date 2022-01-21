package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

public class CombUtils {

    private int[] data;
    private ArrayList<int[]> components = new ArrayList<int[]>();
    private boolean visited;

    public CombUtils(int k) {
//        this.data = data;
        data = new int[k];          // заделяне на памет
    }


    public void printData(){
        System.out.println(Arrays.toString(data));
    }

    public void varRep (int k, int n){

        if (k == 0) {
//            printData();
            components.add(Arrays.copyOf(data, data.length));
            return;
        }

        for (int i = 0; i < n; i++){
            data[k-1] = i;
            varRep(k-1, n);
        }
    }

    public void cleanComponents(){
        if (!(components.isEmpty()))
            components.clear();
    }

    public ArrayList<int[]> generateRep(int k, int n){
        cleanComponents();
        varRep(k, n);
        return new ArrayList<int[]>(components);
    }
}