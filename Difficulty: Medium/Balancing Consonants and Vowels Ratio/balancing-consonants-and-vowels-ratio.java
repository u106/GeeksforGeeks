import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countBalanced(String[] arr) {
        // Map to store frequency of prefix differences (vowels - consonants)
        Map<Integer, Integer> diffCount = new HashMap<>();

        // Base case: prefix sum of 0 appears once initially
        diffCount.put(0, 1);

        int runningDiff = 0;
        int balancedCount = 0;

        for (String s : arr) {
            // Calculate the net difference (vowels - consonants) for the current string
            int v = 0;
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    v++;
                } else {
                    c++;
                }
            }

            runningDiff += (v - c);

            // If the same runningDiff occurred before, every occurrence forms a balanced subarray
            if (diffCount.containsKey(runningDiff)) {
                balancedCount += diffCount.get(runningDiff);
            }

            diffCount.put(runningDiff, diffCount.getOrDefault(runningDiff, 0) + 1);
        }

        return balancedCount;
    }
}