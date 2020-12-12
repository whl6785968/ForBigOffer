package DpDemo;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
        }

        int res = 0;

        for(int r : dp){
            res = Math.max(res,r);
        }

        return res;
    }
}
