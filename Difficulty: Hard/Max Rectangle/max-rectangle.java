import java.util.Stack;

class Solution {
    public int maxArea(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // Build the histogram heights row by row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate max rectangular area for the current histogram
            maxArea = Math.max(maxArea, getMaxAreaHistogram(heights));
        }

        return maxArea;
    }

    private int getMaxAreaHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            // Maintain monotonic increasing stack of indices
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}