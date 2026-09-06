class Solution {
    int floorSqrt(int n) {
        // code here
        int low=1;
        int high=n/2;
        int sq=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==n/mid){
                return mid;
            }else if(mid < n/mid){
                sq=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return sq;
    }
}