class Solution {
     public static int vowelCount(String s) {
         int[] freq = new int[256];
         for (int i = 0; i < s.length(); i++) {
             freq[s.charAt(i)]++;
         }

         char[] vowels = {'a', 'e', 'i', 'o', 'u'};
         int distinctCount = 0;
         long waysToPick = 1;

         for (char v : vowels) {
             if (freq[v] > 0) {
                 distinctCount++;
                 waysToPick *= freq[v];
             }
         }

         if (distinctCount == 0) {
             return 0;
         }

         // distinctCount! permutations for each combination picked
         long factorial = 1;
         for (int i = 2; i <= distinctCount; i++) {
             factorial *= i;
         }

         return (int) (waysToPick * factorial);
     }
 }