import java.util.Arrays;

public class Business{


    public Business(String temp) {
        int index = 0;
        int num1;
        int num2;
        int res;
        int oper;
        char ch;

        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        while (true){
            ch = temp.substring(index, index + 1).charAt(0);
            if (operStack.isOperator(ch)){
                if(!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    numStack.push(ch-48);
                }
                index++;
                if (index >= temp.length()){
                    break;
                }
            }
            while (!operStack.isEmpty()) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = operStack.cal(num1, num2, oper);
                numStack.push(res);
            }
            System.out.println("Expression:"+temp+"="+numStack.pop());

        }
    }
}

class ArrayStack {
    private int MaxSize;
    private int[] arr;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.MaxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        return arr[top];
    }

    public void push(int val){
        top++;
        arr[top] = val;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Празно");
        int val = arr[top];
        top--;
        return val;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("няма данни");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + "\t");;
        }
    }

    public boolean isOperator(char oper){
        return oper == '+' || oper == '-' || oper =='*' || oper == '/';
    }

    public int priority(int oper ){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+': res = num1 + num2;
                break;
            case '-': res = num2 - num1;
                break;
            case '*': res = num1 * num2;
                break;
            case '/': res = num2 /num1;
        }
        return res;
    }
}
