import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> largeDivisors = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i); // Smaller factor
                if (i * i != n) {
                    largeDivisors.add(n / i); // Corresponding larger factor
                }
            }
        }
        
        // Add the larger factors in reverse order to maintain ascending order
        for (int i = largeDivisors.size() - 1; i >= 0; i--) {
            res.add(largeDivisors.get(i));
        }
        
        return res;
    }
}