package String;

import java.util.Stack;

public class BasicCalculatorII227 {
    // TC = O(n)
    // SC = O(n)

    public int calculate(String s) {
        int length = s.length();

        Stack<Integer> numStack = new Stack<>();
        int currentNum = 0;
        char operation = '+';

        for(int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);

            if(Character.isDigit(currentChar)) {
                currentNum = currentChar * 10 + (currentChar - '0');
            }

            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                switch(operation) {
                    case '+':
                        numStack.push(currentNum);
                        break;
                    case '-':
                        numStack.push(-currentNum);
                        break;
                    case '*':
                        numStack.push(numStack.pop() * currentNum);
                        break;
                    case '/':
                        numStack.push(numStack.pop() / currentNum);
                        break;

                }

                operation = currentChar;
                currentNum = 0;
            }
        }
        int res = 0;
        while(!numStack.isEmpty()) {
            res += numStack.pop();
        }

        return res;
    }
}
