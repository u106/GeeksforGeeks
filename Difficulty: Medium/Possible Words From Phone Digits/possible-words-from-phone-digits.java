import java.util.ArrayList;

 class Solution {
     private static final String[] KEYPAD = {
         "",     // 0
         "",     // 1
         "abc",  // 2
         "def",  // 3
         "ghi",  // 4
         "jkl",  // 5
         "mno",  // 6
         "pqrs", // 7
         "tuv",  // 8
         "wxyz"  // 9
     };

     public ArrayList<String> possibleWords(int[] arr) {
         ArrayList<String> result = new ArrayList<>();
         if (arr == null || arr.length == 0) {
             return result;
         }

         solve(0, arr, new StringBuilder(), result);
         return result;
     }

     private void solve(int index, int[] arr, StringBuilder current, ArrayList<String> result) {
         if (index == arr.length) {
             result.add(current.toString());
             return;
         }

         int digit = arr[index];
         String letters = KEYPAD[digit];

         // If the digit is 0 or 1, it maps to no letters, skip to next index
         if (letters.isEmpty()) {
             solve(index + 1, arr, current, result);
             return;
         }

         for (int i = 0; i < letters.length(); i++) {
             current.append(letters.charAt(i));
             solve(index + 1, arr, current, result);
             current.deleteCharAt(current.length() - 1); // Backtrack
         }
     }
 }