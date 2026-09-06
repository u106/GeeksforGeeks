class Solution {
    int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) {
            return 0; // Target is not present
        }
        int last = findLast(arr, target);
        
        return last - first + 1;
    }
    
    // Binary search to find the first occurrence
    private int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                high = mid - 1; // Keep looking left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
    
    // Binary search to find the last occurrence
    private int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                low = mid + 1; // Keep looking right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}