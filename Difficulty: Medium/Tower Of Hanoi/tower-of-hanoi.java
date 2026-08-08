class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // Base case: 0 disks require 0 moves
        if (n == 0) {
            return 0;
        }

        // Step 1: Recursively move (n - 1) disks from 'from' to 'aux' using 'to'
        int count1 = towerOfHanoi(n - 1, from, aux, to);

        // Step 2: Move the nth (largest) disk from 'from' to 'to' (1 move)
        int currentMove = 1;

        // Step 3: Recursively move the (n - 1) disks from 'aux' to 'to' using 'from'
        int count2 = towerOfHanoi(n - 1, aux, to, from);

        // Total moves required for 'n' disks
        return count1 + currentMove + count2;
    }
}