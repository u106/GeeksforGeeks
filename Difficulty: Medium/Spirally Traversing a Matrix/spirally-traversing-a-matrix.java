import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = mat.length - 1;
        int left = 0;
        int right = mat[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right across the top row
            for (int j = left; j <= right; j++) {
                result.add(mat[top][j]);
            }
            top++;

            // Traverse downwards along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse from right to left across the bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(mat[bottom][j]);
                }
                bottom--;
            }

            // Traverse upwards along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}