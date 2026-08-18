class Solution {
    public int minTime(int[] arr, int k) {
        long low = 0;
        long high = 0;

        for (int length : arr) {
            low = Math.max(low, (long) length);
            high += length;
        }

        long result = high;

        // Binary search on the answer (time required)
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1; // Try to find a smaller feasible maximum time
            } else {
                low = mid + 1;  // Increase allowed maximum time
            }
        }

        return (int) result;
    }

    private boolean isPossible(int[] arr, int k, long maxTime) {
        int paintersRequired = 1;
        long currentTime = 0;

        for (int length : arr) {
            if (currentTime + length <= maxTime) {
                currentTime += length;
            } else {
                paintersRequired++;
                currentTime = length;
                if (paintersRequired > k) {
                    return false;
                }
            }
        }

        return true;
    }
}