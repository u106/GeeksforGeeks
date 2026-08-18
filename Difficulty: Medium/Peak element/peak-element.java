class Solution {
     public int peakElement(int[] arr) {
         int n = arr.length;
         int low = 0;
         int high = n - 1;

         while (low < high) {
             int mid = low + (high - low) / 2;

             // If the element on the right is greater, a peak must lie on the right half
             if (arr[mid] < arr[mid + 1]) {
                 low = mid + 1;
             } else {
                 // Otherwise, a peak lies on the left half (including mid)
                 high = mid;
             }
         }

         return low;
     }
 }