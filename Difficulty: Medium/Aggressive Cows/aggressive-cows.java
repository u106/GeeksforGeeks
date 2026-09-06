class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int start=1;
        int end=stalls[stalls.length-1]-stalls[0];
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int n=stalls[0];
            int cows=1;
            boolean r=false;
            for(int num=1;num<stalls.length;num++){
                if(stalls[num]-n>=mid){
                    cows++;
                    n=stalls[num];
                    if(k==cows){
                        r=true;
                    }
                }
            }
            if(r){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
            
        }
        return ans;
    }
}