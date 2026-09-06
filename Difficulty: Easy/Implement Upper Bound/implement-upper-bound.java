class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length-1;
        int index=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>target){
                index=mid;
                high=mid-1;
            } 
            else low=mid+1;
        }
        return index;
    }
}
