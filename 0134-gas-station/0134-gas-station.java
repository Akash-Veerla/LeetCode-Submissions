class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, current = 0;
        for (int i = 0; i < gas.length; i++) {
            int fuel = gas[i] - cost[i];
            total += fuel;
            current += fuel;
            if (current < 0) {
                current = 0;
                start = i + 1;
            }
        }
        return (total < 0) ? -1 : start;
    }
}