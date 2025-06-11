class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ("({[".indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                else if (stack.peek() == '(' && ch == ')') stack.pop();
                else if (stack.peek() == '{' && ch == '}') stack.pop();
                else if (stack.peek() == '[' && ch == ']') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}