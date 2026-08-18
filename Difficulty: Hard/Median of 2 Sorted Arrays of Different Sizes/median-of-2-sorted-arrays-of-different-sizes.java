class Solution {
     public double medianOf2(int a[], int b[]) {
         int n1 = a.length;
         int n2 = b.length;

         // Ensure binary search is performed on the smaller array for O(log(min(n1, n2)))
         if (n1 > n2) {
             return medianOf2(b, a);
         }

         int low = 0;
         int high = n1;
         int leftTotal = (n1 + n2 + 1) / 2;

         while (low <= high) {
             int mid1 = low + (high - low) / 2;
             int mid2 = leftTotal - mid1;

             int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
             int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
             int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
             int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

             if (l1 <= r2 && l2 <= r1) {
                 // Odd total length -> max of left half
                 if ((n1 + n2) % 2 != 0) {
                     return Math.max(l1, l2);
                 }
                 // Even total length -> average of middle two elements
                 return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
             } else if (l1 > r2) {
                 high = mid1 - 1; // Move partition in array 'a' to the left
             } else {
                 low = mid1 + 1;  // Move partition in array 'a' to the right
             }
         }

         return 0.0;
     }
 }