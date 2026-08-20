import java.util.ArrayList;

 class Solution {
     public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
         int n = arr.length;

         // Build prefix sum array
         int[] prefix = new int[n];
         prefix[0] = arr[0];
         for (int i = 1; i < n; i++) {
             prefix[i] = prefix[i - 1] + arr[i];
         }

         ArrayList<Integer> result = new ArrayList<>();

         // Answer each [L, R] query in O(1) time
         for (int[] query : queries) {
             int L = query[0];
             int R = query[1];

             if (L == 0) {
                 result.add(prefix[R]);
             } else {
                 result.add(prefix[R] - prefix[L - 1]);
             }
         }

         return result;
     }
 }