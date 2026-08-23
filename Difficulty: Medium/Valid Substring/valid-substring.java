class Solution {
    public int maxLength(String s) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Push -1 as the initial boundary index
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push index of opening bracket
                stack.push(i);
            } else {
                // Pop the last opening bracket or boundary
                stack.pop();

                if (stack.isEmpty()) {
                    // If stack becomes empty, set current index as the new base boundary
                    stack.push(i);
                } else {
                    // Calculate valid substring length from the current top index
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}