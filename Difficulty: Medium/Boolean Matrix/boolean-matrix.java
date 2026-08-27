class Solution {
    void booleanMatrix(int mat[][]) {
        int r = mat.length;
        int c = mat[0].length;

        boolean row0 = false;
        boolean col0 = false;

        // Check if first row has any 1
        for (int j = 0; j < c; j++) {
            if (mat[0][j] == 1) {
                row0 = true;
                break;
            }
        }

        // Check if first column has any 1
        for (int i = 0; i < r; i++) {
            if (mat[i][0] == 1) {
                col0 = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (mat[i][j] == 1) {
                    mat[i][0] = 1;
                    mat[0][j] = 1;
                }
            }
        }

        // Modify the rest of the matrix based on markers
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (mat[i][0] == 1 || mat[0][j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }

        // Update first row if needed
        if (row0) {
            for (int j = 0; j < c; j++) {
                mat[0][j] = 1;
            }
        }

        // Update first column if needed
        if (col0) {
            for (int i = 0; i < r; i++) {
                mat[i][0] = 1;
            }
        }
    }
}