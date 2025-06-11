class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> sol = new ArrayList<>();
        generate(sol, "", 0, 0, n);
        return sol;
    }
    public static void generate(ArrayList<String> sol, String T, int open, int close, int n) {
        if (T.length() == n * 2) {
            sol.add(T);
            return;
        }
        if (open < n) {
            generate(sol, T + "(", open + 1, close, n);
        }
        if (close < open) {
            generate(sol, T + ")", open, close + 1, n);
        }
    }
}