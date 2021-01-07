package DpDemo;

public class NC108 {
    public int solve (char[][] matrix) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for(int i = 0;i < row;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }

        for(int i = 0;i < col;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }

        int minLength = 0;

        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    minLength = Math.min(dp[i][j],minLength);
                }
            }
        }

        return minLength * minLength;
    }
}
