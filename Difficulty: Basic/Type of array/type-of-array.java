class Solution {
    int typeOfArr(int arr[]) {
        int n = arr.length;
        int maxVal = arr[0];
        int minVal = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }

        // Ascending or Descending Rotated
        if (arr[0] < arr[n - 1]) {
            if (arr[0] == minVal && arr[n - 1] == maxVal) {
                return 1; // Ascending
            }
            return 3; // Descending rotated
        } 
        // Descending or Ascending Rotated
        else {
            if (arr[0] == maxVal && arr[n - 1] == minVal) {
                return 2; // Descending
            }
            return 4; // Ascending rotated
        }
    }
}