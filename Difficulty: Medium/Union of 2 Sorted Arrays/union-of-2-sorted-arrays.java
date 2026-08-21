import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {
            // Pick the smaller element or handle equal elements
            int val;
            if (a[i] < b[j]) {
                val = a[i++];
            } else if (b[j] < a[i]) {
                val = b[j++];
            } else {
                val = a[i];
                i++;
                j++;
            }

            // Append if not duplicate of the last added element
            if (res.isEmpty() || res.get(res.size() - 1) != val) {
                res.add(val);
            }
        }

        // Process remaining elements of a[]
        while (i < n) {
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }

        // Process remaining elements of b[]
        while (j < m) {
            if (res.isEmpty() || res.get(res.size() - 1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }

        return res;
    }
}