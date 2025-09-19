class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    void backTrack(List<String> ans, String currStr, int openB, int closeB, int max) {
        if (currStr.length() == max * 2) {
            ans.add(currStr);
            return;
        }
        if (openB < max)
            backTrack(ans, currStr + "(", openB + 1, closeB, max);
        if (closeB < openB)
            backTrack(ans, currStr + ")", openB, closeB + 1, max);
    }
}