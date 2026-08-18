class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int max=Integer.MIN_VALUE;
        for(int days: arr){
            max=Math.max(max,days);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int bouquet=0;
            int count=0;
            int mid=low+(high-low)/2;
            for(int day:arr){
                if(day <= mid){
                    count++;
                    if(count==k){
                        count=0;
                        bouquet++;
                    }
                }else{
                    count=0;
                }
            }
            if(bouquet>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}