class Solution {
    public int determinantMat(int[][] mat) {
        int n = mat.length;
        return findDeterminant(mat, n);
    }

    private int findDeterminant(int[][] mat, int n) {
        // Base case: 1x1 matrix
        if (n == 1) {
            return mat[0][0];
        }

        // Base case: 2x2 matrix
        if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }

        int det = 0;
        int sign = 1;

        // Iterate over the first row to calculate cofactors
        for (int c = 0; c < n; c++) {
            int[][] subMat = getSubMatrix(mat, n, 0, c);
            det += sign * mat[0][c] * findDeterminant(subMat, n - 1);
            sign = -sign; // Alternating signs: +, -, +, -...
        }

        return det;
    }

    // Helper method to extract the submatrix excluding row 'skipRow' and column 'skipCol'
    private int[][] getSubMatrix(int[][] mat, int n, int skipRow, int skipCol) {
        int[][] sub = new int[n - 1][n - 1];
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (i == skipRow) continue;

            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == skipCol) continue;
                sub[r][c++] = mat[i][j];
            }
            r++;
        }

        return sub;
    }
}