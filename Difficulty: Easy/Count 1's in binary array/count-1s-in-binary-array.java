class Solution {
    public int countOnes(int[] arr) {
        // code here
        int cnt=0;
        for(int n:arr){
            if(n==1) cnt++;
        }
        return cnt;
    }
}