import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            // Check if 'num' is the start of a consecutive sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }
}