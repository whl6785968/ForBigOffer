package DpDemo;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        //text1:abcde,text2:ace
        //dp[i][j]代表了text1.subString(0,i)和text2.subString(0,j)的最大子序列
        //即dp[1][1] 代表着a和a、b、b的最大公共子序列
        //而dp[3][2] 则代表着abc和ac、ce的最大公共子序列
        //可见c相等，则看ab和a的最大公共子序列

        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
