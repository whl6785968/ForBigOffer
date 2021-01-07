package DpDemo;

public class Solution198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = n - 2;i >= 0;i--){
            for(int j = i; j < n;j++){
                dp[i] = Math.max(dp[i],dp[j] + (j + 2 < n ? dp[j+2] : 0));
            }
        }

        return dp[n-1];
    }
}
