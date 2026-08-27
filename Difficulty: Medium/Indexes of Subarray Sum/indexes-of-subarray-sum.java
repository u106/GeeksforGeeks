
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        int sum=0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            while(sum>target && index<i){
                sum-=arr[index++];
            }
            if(sum==target){
                res.add(index+1);
                res.add(i+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}
