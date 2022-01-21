import java.util.Arrays;
import java.util.Stack;

public class Calculation extends Stack {

    public Calculation(String temp) {

        Stack<Integer> argsSt = new Stack<>();
        Stack<String> opsSt = new Stack<>();

        temp = "3+2*5-8/4";
        //          4
        // /        8
        // -        5
        // *        2
        // +        3

        char[] ch = temp.toCharArray();

        for (char i : ch) {
                if (Character.isDigit(i)) {

                    int item = Integer.parseInt(String.valueOf(i));
                    argsSt.push(item);
                } else if (!Character.isDigit(i)) {
                    if (i == '*'){
                        opsSt.push(Character.toString(i));
                    } else if (i == '/') {
                        opsSt.push(Character.toString(i));

                    } else {
                        opsSt.push(Character.toString(i));
                    }
                }
        }

        System.out.println(opsSt + "\n" + argsSt);
    }

    public static void main(String[] args) {
        Calculation calculate = new Calculation("asd");

    }
}



/**
 if (c == '*') {
 opsSt.push(c);
 //                    int argStLasEle = argsSt.lastElement() * temp.charAt(i + 1);
 //                    argsSt.push(argStLasEle);
 } else if (c == '-') {
 opsSt.push(c);
 } else if (c == '+') {
 opsSt.push(c);
 } else if (c == '/') {
 opsSt.push(c);
 } else {
 argsSt.push((int) c);
 }
 **/