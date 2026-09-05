import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int x : arr) {
            boolean destroyed = false;

            while (!st.isEmpty() && ((st.peek() > 0 && x < 0) || (st.peek() < 0 && x > 0))) {
                int topAbs = Math.abs(st.peek());
                int curAbs = Math.abs(x);

                if (topAbs == curAbs) {
                    st.pop();
                    destroyed = true;
                    break;
                } else if (topAbs > curAbs) {
                    destroyed = true;
                    break;
                } else {
                    // Current element has greater absolute value, destroy top and continue
                    st.pop();
                }
            }

            if (!destroyed) {
                st.push(x);
            }
        }

        return new ArrayList<>(st);
    }
}