class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        // Iterate through all possible left column boundaries
        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            // Iterate through all possible right column boundaries
            for (int right = left; right < m; right++) {
                // Add current column's values to cumulative row sums
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }

                // Standard 1D Kadane's Algorithm on temp[]
                int currentSum = temp[0];
                int maxSubArraySum = temp[0];
                for (int i = 1; i < n; i++) {
                    currentSum = Math.max(temp[i], currentSum + temp[i]);
                    maxSubArraySum = Math.max(maxSubArraySum, currentSum);
                }

                maxSum = Math.max(maxSum, maxSubArraySum);
            }
        }
        return maxSum;
    }
}