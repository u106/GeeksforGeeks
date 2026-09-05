class GetMin {
    public static Stack<Integer> _push(int arr[], int n) {
        // code here
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()) st.push(arr[i]);
            else st.push(Math.min(arr[i],st.peek()));
        }
        return st;
    }

    static void _getMinAtPop(Stack<Integer> s) {
        // code here
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}