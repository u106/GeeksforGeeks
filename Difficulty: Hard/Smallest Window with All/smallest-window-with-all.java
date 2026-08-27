class Solution {
    public static String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return "";
        }

        int[] req = new int[256];
        for (int i = 0; i < p.length(); i++) {
            req[p.charAt(i)]++;
        }

        int[] window = new int[256];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            window[rChar]++;

            // If current character contributes to matching string p
            if (req[rChar] > 0 && window[rChar] <= req[rChar]) {
                count++;
            }

            // When all characters of p are matched
            if (count == p.length()) {
                // Shrink the window from the left
                while (window[s.charAt(left)] > req[s.charAt(left)] || req[s.charAt(left)] == 0) {
                    window[s.charAt(left)]--;
                    left++;
                }

                // Update the minimum window length and starting index
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    startIndex = left;
                }
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}