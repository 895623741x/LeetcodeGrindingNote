package DataStructure;

import java.util.Stack;

public class MinStack155 {
    Stack<Integer> inputStack;
    Stack<Integer> minimumStack;
    public MinStack() {
        inputStack = new Stack<>();
        minimumStack = new Stack<>();
    }

    public int getMin(){
        return minimumStack.peek();
    }

    public void push(int x){

        if(minimumStack.isEmpty()) {
            minimumStack.push(x);
            // if the given value is smaller than the current minimum value on the top of the minimumStack, we push
            // it to the top of the minimumStack and
        } else if(x <= minimumStack.peek()) {
            minimumStack.push(x);
        }

        inputStack.push(x);
    }
    public void pop(){
        // we will use equals because "==" does not work here
        if(inputStack.peek().equals(minimumStack.peek())) {
            minimumStack.pop();
        }
        inputStack.pop();
    }
    public int top() {
        return inputStack.peek();
    }
}
