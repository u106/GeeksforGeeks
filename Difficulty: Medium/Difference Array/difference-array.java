class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        // code here
        int[] ans=new int[arr.length];
        for(int k=0;k<opr.length;k++){
            int i=opr[k][0];
            int j=opr[k][1];
            int x=opr[k][2];
            ans[i]+=x;
            if(j!=arr.length-1){
                ans[j+1]-=x;
            }
        }
        for(int i=1;i<arr.length;i++){
            ans[i]+=ans[i-1];
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            res.add(ans[i]+arr[i]);
        }
        return res;
    }
}
