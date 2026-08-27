class Solution {
    public void rotateMatrix(int[][] mat) {
        int n = mat.length;

        // Swap symmetric elements across the center
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = temp;
            }
        }

        // If n is odd, reverse the middle row
        if (n % 2 != 0) {
            int mid = n / 2;
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[mid][j];
                mat[mid][j] = mat[mid][n - 1 - j];
                mat[mid][n - 1 - j] = temp;
            }
        }
    }
}