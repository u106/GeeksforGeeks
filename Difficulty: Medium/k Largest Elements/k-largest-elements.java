class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> min=new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            min.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]>min.peek()){
                min.poll();
                min.add(arr[i]);
            }
        }
        while(!min.isEmpty()){
            res.add(min.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
