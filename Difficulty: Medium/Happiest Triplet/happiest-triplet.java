import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    ArrayList<Integer> smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        int resA = 0, resB = 0, resC = 0;

        while (i < a.length && j < b.length && k < c.length) {
            int currentMin = Math.min(a[i], Math.min(b[j], c[k]));
            int currentMax = Math.max(a[i], Math.max(b[j], c[k]));
            int currentDiff = currentMax - currentMin;
            int currentSum = a[i] + b[j] + c[k];

            if (currentDiff < minDiff || (currentDiff == minDiff && currentSum < minSum)) {
                minDiff = currentDiff;
                minSum = currentSum;
                resA = a[i];
                resB = b[j];
                resC = c[k];
            }

            // Advance the pointer pointing to the minimum value
            if (a[i] == currentMin) {
                i++;
            } else if (b[j] == currentMin) {
                j++;
            } else {
                k++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(resA);
        result.add(resB);
        result.add(resC);

        // Return the triplet in descending order
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}