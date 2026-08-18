class Solution {
    public static void reverseStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        int n = st.size();

        for (int i = 0; i < n; i++) {
            // 1. Pop the top element of the remaining unreversed section
            int element = st.pop();

            // 2. Move the remaining (n - 1 - i) elements to 'temp'
            while (st.size() > i) {
                temp.push(st.pop());
            }

            // 3. Push the target element to its new position
            st.push(element);

            // 4. Move everything back from 'temp' to 'st'
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }
    }
}