import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            // Remove the element leaving the window
            int outgoing = arr[i - k];
            if (freqMap.get(outgoing) == 1) {
                freqMap.remove(outgoing);
            } else {
                freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            }

            // Add the new element entering the window
            int incoming = arr[i];
            freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);

            // Record distinct count
            result.add(freqMap.size());
        }

        return result;
    }
}