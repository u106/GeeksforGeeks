import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findSubarray(int[] arr) {
        // Map to store frequency of prefix sums
        Map<Long, Integer> prefixSumFreq = new HashMap<>();

        long currentSum = 0;
        int count = 0;

        // Base case: a prefix sum of 0 has occurred once before processing elements
        prefixSumFreq.put(0L, 1);

        for (int num : arr) {
            currentSum += num;

            // If the current prefix sum has appeared before, add its frequency to count
            if (prefixSumFreq.containsKey(currentSum)) {
                count += prefixSumFreq.get(currentSum);
            }

            // Update the frequency of the current prefix sum
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}