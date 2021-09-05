package DataStructure;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        // TC = O(n), n is the length of the string s
        // SC = O(n + |x|), x is the number of types of parentheses and n is the length of string s

        if(s.length() % 2 != 0) return false;

        Stack<Character> charStack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                charStack.push(c);
            } else if(c == ')' && !charStack.isEmpty() && charStack.peek() == '(') {
                charStack.pop();
            } else if(c == ']' && !charStack.isEmpty() && charStack.peek() == '[') {
                charStack.pop();
            } else if(c == '}' && !charStack.isEmpty() && charStack.peek() == '{') {
                charStack.pop();
            } else {
                // this is only possible when charStack is empty
                return false;
            }
        }

        return charStack.isEmpty();
    }
}
