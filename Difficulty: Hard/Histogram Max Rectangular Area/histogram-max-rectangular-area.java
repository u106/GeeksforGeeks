import java.util.Stack;

class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // When reaching the end, consider a dummy height of 0 to clear remaining bars in stack
            int currentHeight = (i == n) ? 0 : arr[i];

            // Maintain a monotonic increasing stack
            while (!st.isEmpty() && currentHeight < arr[st.peek()]) {
                int height = arr[st.pop()];
                // If stack is empty, width spans from 0 to i - 1 (width = i)
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}