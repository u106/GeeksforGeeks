class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        // If there are more students than books, allocation is impossible
        if (k > n) {
            return -1;
        }

        long low = 0;
        long high = 0;
        for (int pages : arr) {
            low = Math.max(low, (long) pages);
            high += pages; // Use long to prevent integer overflow
        }

        long result = -1;

        // Binary Search on Answer
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1;  // Increase the page limit
            }
        }

        return (int) result;
    }

    private boolean isPossible(int[] arr, int k, long maxPages) {
        int studentsRequired = 1;
        long currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                studentsRequired++;
                currentPages = pages;
                if (studentsRequired > k) {
                    return false;
                }
            }
        }

        return true;
    }
}