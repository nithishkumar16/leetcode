class LongestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n][m];

         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j] = -1;
            }
        }

        return helper(0, text1, 0, text2, dp);
    }

    public int helper(int i, String text1, int j, String text2, int[][] dp)
    {
        if(i==text1.length() || j==text2.length())
        {
            return 0;
        }

         if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j))
        {
            return dp[i][j] = 1 + helper(i+1,text1,j+1,text2,dp);
        }
        else{
            return dp[i][j] = Math.max(helper(i+1,text1,j,text2,dp), helper(i,text1,j+1,text2,dp));
        }

    }
}