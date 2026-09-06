class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> st=new Stack<>();
        int n=mat.length;
        for(int i=0;i<n;i++) st.push(i);
        while(st.size()>1){
            int a=st.pop();
            int b=st.pop();
            if(mat[a][b]==1){
                st.push(b);
            }else{
                st.push(a);
            }
        }
        int candidate=st.pop();
        for(int i=0;i<n;i++){
            if(i==candidate) continue;
            if(mat[candidate][i]==1 || mat[i][candidate]==0) return -1;
        }
        return candidate;
    }
}