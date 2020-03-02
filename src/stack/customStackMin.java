package stack;
import java.util.Arrays;
import java.util.Stack;

public class customStackMin extends Stack<Integer> {

    // extra stack to store min value at each level of data entered
    Stack<Integer> minStack = new Stack();

    // enter data into the stack
    void push(int number){
        if (isEmpty() == true){
            super.push(number);
            minStack.push(number);
        }else{
            super.push(number);
            int min = minStack.pop();
            minStack.push(min);
            if (min < number){
                minStack.push(min);
            }else{
                minStack.push(number);
            }
        }
    }

    // pop data from stack
    public Integer pop(){
        int temp = super.pop();
        minStack.pop();
        return temp;
    }

    // function return min value from number which have been entered till now
    int getMin() {
        int min = minStack.pop();
        minStack.push(min);
        return min;
    }
    public static void main(String args[]){
        // special stack class
        customStackMin cs = new customStackMin();
        cs.push(4);
        cs.push(2);
        cs.push(9);
        // checking entries in both the stacks
        System.out.println(Arrays.toString(cs.minStack.toArray()));
        System.out.println(Arrays.toString(cs.toArray()));
        // get min from the values
        System.out.println(cs.getMin());
    }
}
