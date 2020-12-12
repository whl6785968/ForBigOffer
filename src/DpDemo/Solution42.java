package DpDemo;

public class Solution42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int maxValue = nums[0];
        for(int i = 1;i < n;i++){
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
            maxValue = Math.max(maxValue,dp[i]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution42 solution42 = new Solution42();
        solution42.maxSubArray(nums);
    }
}
