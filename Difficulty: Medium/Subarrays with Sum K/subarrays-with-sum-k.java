import java.util.HashMap;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case: prefix sum of 0 appears once

        int currentSum = 0;
        int count = 0;

        for (int num : arr) {
            currentSum += num;

            // If (currentSum - k) exists, add its frequency to count
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }

            // Update the frequency of the current prefix sum
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}