import java.util.Stack;

class Solution {
    static String preToInfix(String s) {
        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // Check if the character is an operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^') {
                String op1 = stack.pop();
                String op2 = stack.pop();

                // Form infix subexpression with parentheses: (op1 operator op2)
                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            } else {
                // Character is an operand, push to stack
                stack.push(String.valueOf(ch));
            }
        }

        return stack.peek();
    }
}