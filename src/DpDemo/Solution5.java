package DpDemo;

public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n < 2) return s;

        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i < n;i++){
            dp[i][i] = true;
        }

        int max_length = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        for(int j = 1;j < n;j++){
            for(int i = 0;i < j;i++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }
                else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > max_length){
                    begin = i;
                    max_length = j - i + 1;
                }
            }

        }


        return s.substring(begin,begin + max_length);

    }
}
