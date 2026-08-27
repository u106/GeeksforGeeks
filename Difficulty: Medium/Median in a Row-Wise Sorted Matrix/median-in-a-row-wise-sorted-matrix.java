class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int required = (n * m + 1) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countLessOrEqual(mat[i], mid);
            }

            if (count < required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Helper function to count elements <= target in a sorted row
    private int countLessOrEqual(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}