class Solution {
     static int perfectSum(int[] arr, int target) {
         int[] dp = new int[target + 1];

         // Base case: 1 way to form a sum of 0 using an empty subset
         dp[0] = 1;

         for (int num : arr) {
             // Traverse backwards to avoid reusing the same element
             for (int sum = target; sum >= num; sum--) {
                 dp[sum] += dp[sum - num];
             }
         }

         return dp[target];
     }
 }