import java.util.HashMap;

class Solution {
    public int maxLen(int[] arr) {
        // Map to store (prefix_sum -> first occurrence index)
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            // Treat 0 as -1 and 1 as +1
            prefixSum += (arr[i] == 0) ? -1 : 1;

            // If prefixSum is 0, subarray from 0 to i has equal 0s and 1s
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // If prefixSum was seen before, subarray between the two indices has sum 0
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // Store only the first occurrence to maximize the length
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}