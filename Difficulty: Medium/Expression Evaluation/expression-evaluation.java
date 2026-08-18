import java.util.Stack;

 class Solution {
     public int evaluateInfix(String[] arr) {
         Stack<Integer> values = new Stack<>();
         Stack<String> ops = new Stack<>();

         for (String token : arr) {
             if (isOperator(token)) {
                 // While top operator has higher precedence, or same precedence if left-associative
                 while (!ops.isEmpty() && shouldEvaluate(ops.peek(), token)) {
                     int val2 = values.pop();
                     int val1 = values.pop();
                     String op = ops.pop();
                     values.push(applyOp(op, val1, val2));
                 }
                 ops.push(token);
             } else {
                 values.push(Integer.parseInt(token));
             }
         }

         // Process all remaining operators in the stack
         while (!ops.isEmpty()) {
             int val2 = values.pop();
             int val1 = values.pop();
             String op = ops.pop();
             values.push(applyOp(op, val1, val2));
         }

         return values.pop();
     }

     private boolean isOperator(String s) {
         return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
     }

     private int precedence(String op) {
         switch (op) {
             case "+":
             case "-":
                 return 1;
             case "*":
             case "/":
                 return 2;
             case "^":
                 return 3;
             default:
                 return 0;
         }
     }

     private boolean shouldEvaluate(String topOp, String currentOp) {
         int precTop = precedence(topOp);
         int precCurr = precedence(currentOp);

         // Standard left-associative operators trigger on >= precedence.
         // Right-associative '^' triggers only on strictly > precedence.
         if (currentOp.equals("^")) {
             return precTop > precCurr;
         }
         return precTop >= precCurr;
     }

     private int applyOp(String op, int a, int b) {
         switch (op) {
             case "+":
                 return a + b;
             case "-":
                 return a - b;
             case "*":
                 return a * b;
             case "/":
                 return Math.floorDiv(a, b);
             case "^":
                 return (int) Math.pow(a, b);
             default:
                 return 0;
         }
     }
 }