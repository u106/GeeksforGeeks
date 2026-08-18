class Solution {
     public int[] twoRepeated(int[] arr) {
         int[] result = new int[2];
         int idx = 0;

         for (int i = 0; i < arr.length; i++) {
             int val = Math.abs(arr[i]);

             // If the element at index (val) is already negative, val is repeating
             if (arr[val] < 0) {
                 result[idx++] = val;
                 if (idx == 2) {
                     break;
                 }
             } else {
                 // Negate the value at index val to mark it as seen
                 arr[val] = -arr[val];
             }
         }

         return result;
     }
 }