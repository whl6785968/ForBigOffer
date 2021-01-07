package DpDemo.packageDemo;

public class Solution2 {

    public int solve(int m,int n,int[] weight,int[] value){
        int[] dp = new int[n+1];

        for(int i = 0;i < m;i++){
            for(int j = weight[i];j <= n;j++){
                dp[j] = Math.max(dp[j],value[i] + dp[j - weight[i]]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] weight = {1,2,3,4};
        int[] value = {2,4,4,5};

        int solve = solution2.solve(4, 5, weight, value);
        System.out.println(solve);
    }
}
