class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]) max=arr[i];
        }
        int low=0;
        int high=max;
        int speed=0;
        while(low<=high){
            long time=0;
            int mid=(low+(high-low)/2);
            for(int pile:arr){
                time+=Math.ceil((double)pile/mid);
            }
            if(time<=k){
                speed=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return (int)speed;
    }
}
