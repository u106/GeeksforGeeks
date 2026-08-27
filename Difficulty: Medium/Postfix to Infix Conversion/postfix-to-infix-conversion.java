import java.util.Stack;

class Solution {
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If the character is an operand (letter or digit), push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                // Operator encountered: pop top two operands
                String op2 = stack.pop();
                String op1 = stack.pop();

                // Concatenate in infix form: (op1 + operator + op2)
                String combined = "(" + op1 + ch + op2 + ")";
                stack.push(combined);
            }
        }

        return stack.peek();
    }
}