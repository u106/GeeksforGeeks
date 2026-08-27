class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];   // Previous smaller element index
        int[] right = new int[n];  // Next smaller element index

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Find previous smaller element for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find next smaller element for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // ans[k] stores max of min for window length k
        int[] ans = new int[n + 1];

        // Fill answer for maximum possible window where arr[i] is minimum
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining entries: a minimum for window of size len 
        // is also valid for any smaller window size
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(ans[i]);
        }

        return result;
    }
}