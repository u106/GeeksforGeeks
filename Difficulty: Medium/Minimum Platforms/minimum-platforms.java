import java.util.Arrays;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;

        // Sort both arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        // Two-pointer traversal
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }
}