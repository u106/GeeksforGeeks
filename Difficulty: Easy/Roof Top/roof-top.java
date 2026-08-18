class Solution {
     public int maxStep(int[] arr) {
         int maxSteps = 0;
         int currentSteps = 0;

         for (int i = 1; i < arr.length; i++) {
             // Step to a strictly higher building
             if (arr[i] > arr[i - 1]) {
                 currentSteps++;
                 maxSteps = Math.max(maxSteps, currentSteps);
             } else {
                 // Reset consecutive step count
                 currentSteps = 0;
             }
         }

         return maxSteps;
     }
 }