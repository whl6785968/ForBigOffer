package GraphDemo;

public class Solution13 {

    public boolean[][] visited;
    public int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public int movingCount(int m, int n, int k) {

        visited = new boolean[m][n];
        int res = recur(m,n,0,0,k);
        return res;
    }

    public int recur(int row,int col,int i,int j,int k){
        visited[i][j] = true;

        int res = 1;
        for(int d = 0;d < 4;d++){
            int nextX = i + dirs[d][0];
            int nextY = j + dirs[d][1];

            if(!isValid(row,col,nextX,nextY) && !visited[nextX][nextY] && getValue(nextX,nextY) <= k){
                res += recur(row,col,nextX,nextY,k);
            }
        }

        return res;
    }

    public int getValue(int x,int y){
        return x / 10 + x % 10 + y / 10 + y % 10;
    }


    public boolean isValid(int row,int col,int m,int n){
        return (m >= 0 && m < row) && (n >= 0 && n < col);
    }
}
