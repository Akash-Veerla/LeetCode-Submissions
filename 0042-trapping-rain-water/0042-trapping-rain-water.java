class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) {
                int top = s.pop();
                if (s.isEmpty()) {
                    break;
                }
                int distance = i - s.peek() - 1;
                int boundedHeight = Math.min(height[i], height[s.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            s.push(i);
        }
        return water;
    }
}