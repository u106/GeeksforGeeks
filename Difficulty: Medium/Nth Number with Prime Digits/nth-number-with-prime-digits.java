class Solution {
    public int primeDigits(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int rem = n % 4;
            if (rem == 1) {
                sb.append('2');
                n = n / 4;
            } else if (rem == 2) {
                sb.append('3');
                n = n / 4;
            } else if (rem == 3) {
                sb.append('5');
                n = n / 4;
            } else { // rem == 0
                sb.append('7');
                n = (n / 4) - 1;
            }
        }

        return Integer.parseInt(sb.reverse().toString());
    }
}