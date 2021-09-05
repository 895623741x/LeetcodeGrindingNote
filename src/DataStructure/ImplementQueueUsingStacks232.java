package DataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks232 {
    // we will use two deques to solve this question. One of these deques will be used for "push" and the other one
    // will be used for "pop" and "peek".

    // every time we use "pop" or "peek", if outputStack is empty, we will pop all the elements out from the
    // inputStack and then push them into the outputStack sequentially. The first element that was pushed into the
    // inputStack will then be at the top of the outputStack.

    // TC = O(1), because each element will at most be pushed and popped twice
    // SC = O(n), n is the number of elements in the stack when n times of "push" are implemented

    class MyQueue {
        // instead of using Deque<Integer> = new LinkedList<>(), we can also use Stack<Integer> = new Stack<>().
        Deque<Integer> inputStack;
        Deque<Integer> outputStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            inputStack  = new LinkedList<>();
            outputStack = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(outputStack.isEmpty()) {
                while(!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(outputStack.isEmpty()) {
                while(!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }

}
