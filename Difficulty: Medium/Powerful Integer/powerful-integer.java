import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int powerfulInteger(int[][] arr, int k) {
        // Line sweep using TreeMap to keep events sorted
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : arr) {
            int start = interval[0];
            int end = interval[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            // The interval is inclusive [start, end], so the decrement happens at end + 1
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int currentOverlap = 0;
        int maxPowerful = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int change = entry.getValue();

            // If the interval leading up to this point met the threshold k,
            // the maximum integer in that region was (point - 1)
            if (currentOverlap >= k) {
                maxPowerful = Math.max(maxPowerful, point - 1);
            }

            currentOverlap += change;

            // Check if at the exact point it satisfies the condition
            if (currentOverlap >= k) {
                maxPowerful = Math.max(maxPowerful, point);
            }
        }

        return maxPowerful;
    }
}