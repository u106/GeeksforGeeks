import java.util.HashMap;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        int maxLen = 0;
        int currentDiff = 0;

        // Map to store the first occurrence of each prefix difference sum
        HashMap<Integer, Integer> diffMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Update running difference
            currentDiff += (a1[i] - a2[i]);

            // If the difference becomes 0, span starts from index 0
            if (currentDiff == 0) {
                maxLen = i + 1;
            } 
            // If this difference sum has been seen before, calculate span length
            else if (diffMap.containsKey(currentDiff)) {
                maxLen = Math.max(maxLen, i - diffMap.get(currentDiff));
            } 
            // Record the first occurrence of the current difference sum
            else {
                diffMap.put(currentDiff, i);
            }
        }

        return maxLen;
    }
}