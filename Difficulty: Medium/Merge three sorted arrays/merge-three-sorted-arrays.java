import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> mergeThree(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int n = a.length, m = b.length, p = c.length;

        while (i < n || j < m || k < p) {
            int valA = (i < n) ? a[i] : Integer.MAX_VALUE;
            int valB = (j < m) ? b[j] : Integer.MAX_VALUE;
            int valC = (k < p) ? c[k] : Integer.MAX_VALUE;

            if (valA <= valB && valA <= valC) {
                result.add(a[i]);
                i++;
            } else if (valB <= valA && valB <= valC) {
                result.add(b[j]);
                j++;
            } else {
                result.add(c[k]);
                k++;
            }
        }

        return result;
    }
}