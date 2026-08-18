import java.util.Arrays;

class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;

        // Sort the array to use two-pointer technique
        Arrays.sort(arr);

        // Fix the first element and search for the remaining two
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }

        return false;
    }
}