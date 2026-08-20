class Solution {
     public static int countSetBits(int n) {
         int totalSetBits = 0;
         int num = n + 1; // Consider range [0, n], which has n + 1 numbers

         // Iterate through each bit position (0 to 30)
         for (int i = 0; (1 << i) <= n; i++) {
             int period = 1 << (i + 1);
             int fullCycles = num / period;

             // Set bits contributed by complete cycles
             totalSetBits += fullCycles * (1 << i);

             // Set bits contributed by the remainder
             int remainder = num % period;
             totalSetBits += Math.max(0, remainder - (1 << i));
         }

         return totalSetBits;
     }
 }