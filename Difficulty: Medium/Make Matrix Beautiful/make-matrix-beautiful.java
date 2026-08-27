class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;

        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                totalSum += mat[i][j];
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, Math.max(rowSum[i], colSum[i]));
        }

        return (maxSum * n) - totalSum;
    }
}