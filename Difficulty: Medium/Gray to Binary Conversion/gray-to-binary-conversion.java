class Solution {
     public static int grayToBinary(int n) {
         int b = 0;
         while (n > 0) {
             b ^= n;
             n >>= 1;
         }
         return b;
     }
 }