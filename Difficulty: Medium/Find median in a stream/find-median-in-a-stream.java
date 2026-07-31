import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        
        // Max heap to store the smaller half of numbers
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Min heap to store the larger half of numbers
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        for (int num : arr) {
            // Step 1: Insert into appropriate heap
            if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
                leftMaxHeap.add(num);
            } else {
                rightMinHeap.add(num);
            }

            // Step 2: Rebalance heaps to ensure leftMaxHeap has at most 1 extra element
            if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
                rightMinHeap.add(leftMaxHeap.poll());
            } else if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }

            // Step 3: Calculate median
            if (leftMaxHeap.size() == rightMinHeap.size()) {
                double median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
                result.add(median);
            } else {
                double median = (double) leftMaxHeap.peek();
                result.add(median);
            }
        }

        return result;
    }
}