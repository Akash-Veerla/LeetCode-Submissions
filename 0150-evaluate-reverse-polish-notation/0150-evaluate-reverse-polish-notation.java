class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int right, left, value;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                right = Integer.valueOf(st.pop());
                left = Integer.valueOf(st.pop());
                value = left + right;
                st.push(value);
            } else if (tokens[i].equals("/")) {
                right = Integer.valueOf(st.pop());
                left = Integer.valueOf(st.pop());
                value = left / right;
                st.push(value);
            } else if (tokens[i].equals("*")) {
                right = Integer.valueOf(st.pop());
                left = Integer.valueOf(st.pop());
                value = left * right;
                st.push(value);
            } else if (tokens[i].equals("-")) {
                right = Integer.valueOf(st.pop());
                left = Integer.valueOf(st.pop());
                value = left - right;
                st.push(value);
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
    }
}