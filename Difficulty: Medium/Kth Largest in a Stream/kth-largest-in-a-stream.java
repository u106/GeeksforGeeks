class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);

            // Maintain the heap size at most k
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // If heap size is less than k, kth largest element doesn't exist yet
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(minHeap.peek());
            }
        }

        return result;
    }
}