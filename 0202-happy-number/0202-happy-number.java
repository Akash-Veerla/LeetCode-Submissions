class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sum(n);
        }
        return n == 1;
    }
    private int sum(int n) {
        int s = 0;
        int d;
        while (n > 0) {
            d = n % 10;
            s += d * d;
            n /= 10;
        }
        return s;
    }
}