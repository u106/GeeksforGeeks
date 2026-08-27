class Solution {
    public long findRank(String s) {
        int n = s.length();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        long rank = 1;
        for (int i = 0; i < n; i++) {
            // Count characters to the right of s[i] that are lexicographically smaller
            int smallerCount = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) < s.charAt(i)) {
                    smallerCount++;
                }
            }

            // Add permutations starting with smaller characters
            rank += smallerCount * fact[n - 1 - i];
        }

        return rank;
    }
}