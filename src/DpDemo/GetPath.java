package DpDemo;

public class GetPath {
    public int uniquePaths (int m, int n) {
        // write code here
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i < m;i++){
            dp[i][0] = 1;
        }

        for(int i = 0;i < n;i++){
            dp[0][i] = 1;
        }

        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        GetPath getPath = new GetPath();
        int i = getPath.uniquePaths(2, 1);
        System.out.println(i);
    }
}
