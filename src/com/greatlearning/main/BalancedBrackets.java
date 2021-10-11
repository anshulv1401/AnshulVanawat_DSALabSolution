package com.greatlearning.main;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String bracketExpression = "{{[({})]}}";

        if (isBalanced(bracketExpression)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }

    private static boolean isBalanced(String bracketExpression) {
        Stack<Character> stack = new Stack<>();

        // iterate through each Char at index i - charAt() method
        for (char c : bracketExpression.toCharArray()) {
            //if char is open bracket '(' '{' '['
            //  then push to stack
            //else
            //  if the stack is empty return false
            //  pop from the stack and check
            //  if popped char is closing bracket for c
            //   do nothing
            //  else
            //   return false
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char s = stack.pop();
                if ((s == '(' && c != ')')
                        || (s == '[' && c != ']')
                        || (s == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
