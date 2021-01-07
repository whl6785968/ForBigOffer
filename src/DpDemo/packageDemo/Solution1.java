package DpDemo.packageDemo;

public class Solution1 {
    public int solve(int m,int n,int[] weight,int[] value){
        int[][] dp = new int[m][n+1];

        //m：物品个数
        //n：容量
        for(int j = 0; j <= n;j++){
            if(j >= weight[0]){
                dp[0][j] = value[0];
            }
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j <= n;j++){
                if(j >= weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j],value[i] + dp[i-1][j-weight[i]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }


            }
        }

        return dp[m-1][n];
    }

    public int solve2(int m,int n,int[] weight,int[] value){
        int[] dp = new int[n+1];

        for(int i = 0;i <= n;i++){
            if(i >= weight[0]){
                dp[i] = value[0];
            }
        }

        for(int i = 1;i < m;i++){
            for(int j = n;j >= weight[i];j--){
                dp[j] = Math.max(dp[j],value[i] + dp[j - weight[i]]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] weight = {1,2,3,4};
        int[] value = {2,4,4,5};

        int solve = solution1.solve2(4, 5, weight, value);
        System.out.println(solve);
    }
}
