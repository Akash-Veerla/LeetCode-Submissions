class Solution {
    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int prevDiag = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[j] = 1 + prevDiag;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prevDiag = temp;
            }
        }
        return dp[m];
    }
}