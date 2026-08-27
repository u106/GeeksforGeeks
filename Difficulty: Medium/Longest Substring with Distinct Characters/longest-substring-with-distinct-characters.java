import java.util.Arrays;

class Solution {
    public int longestUniqueSubstr(String s) {
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen within the current window, move the left pointer
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }

            // Update the last seen index of the character
            lastIndex[currentChar] = right;

            // Calculate max length of valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}