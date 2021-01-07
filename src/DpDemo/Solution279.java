package DpDemo;

import java.util.Arrays;

public class Solution279 {
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        int max_square_index = (int)Math.sqrt(n) + 1;
        int[] square_num = new int[max_square_index];

        for(int i = 1;i < max_square_index;i++){
            square_num[i] = i * i;
        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j < max_square_index;j++){
                if(i < square_num[j]) break;

                dp[i] = Math.min(dp[i],dp[i - square_num[j]] + 1);
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        int i = solution279.numSquares(12);
        System.out.println(i);
    }
}
