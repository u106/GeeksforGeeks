import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int distinct(int[][] mat) {
        int n = mat.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Insert unique elements of the first row
        for (int j = 0; j < n; j++) {
            map.put(mat[0][j], 1);
        }

        // Process remaining rows
        for (int i = 1; i < n; i++) {
            // Use a set to avoid processing duplicate elements in the same row
            Set<Integer> uniqueInRow = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueInRow.add(mat[i][j]);
            }

            for (int val : uniqueInRow) {
                // If the element appeared in all previous i rows, increment its count
                if (map.containsKey(val) && map.get(val) == i) {
                    map.put(val, i + 1);
                }
            }
        }

        // Count elements that appeared in all n rows
        int commonCount = 0;
        for (int count : map.values()) {
            if (count == n) {
                commonCount++;
            }
        }

        return commonCount;
    }
}