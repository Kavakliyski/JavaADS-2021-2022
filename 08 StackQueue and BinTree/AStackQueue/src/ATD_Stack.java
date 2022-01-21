import java.util.Stack;

public class ATD_Stack<E> extends Stack {
    // E - базов тип на елементите, клас
    // FILO - First in last out

//    спецификация на базовия тип и конструктор
    Stack<Integer> st = new Stack<Integer>();

    public static void main(String[] args) {
        ATD_Stack<Integer> st = new ATD_Stack<Integer>();
        st.push(3);
        st.push(12);
        st.push(2);
        st.push(4);
        st.push(100);
        System.out.println("full: " +  st);

        System.out.println("el: " + st.pop());
        System.out.println("el: " + st.pop());

        System.out.println("after pop: " +  st);

        st.push(3);
        st.push(12);
        st.push(2);
        st.push(4);
        while (!st.isEmpty()){ // проверка за празен стек
            System.out.println("el: " + st.pop());
        }
    }
}
