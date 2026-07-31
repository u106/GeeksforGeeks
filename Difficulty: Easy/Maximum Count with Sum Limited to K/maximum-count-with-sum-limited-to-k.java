class Solution {
    static int toyCount(int arr[], int k) {
        // code here
        int sum=0;
        int count=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=k){
                sum+=arr[i];
                count++;
            }
        }
        return  count;
    }
}