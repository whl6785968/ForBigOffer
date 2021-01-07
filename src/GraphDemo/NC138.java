package GraphDemo;

public class NC138 {
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    boolean[][] visited;
    int res = 0;

    public int solve (int[][] matrix) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;

        visited = new boolean[row][col];

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                dfs(matrix,i,j,row,col,1);
            }
        }

        return res;
    }

    public void dfs(int[][] matrix,int x,int y,int row,int col,int depth){
        visited[x][y] = true;

        for(int d = 0;d < 4;d++){
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if(isValid(nextX,nextY,row,col) && !visited[nextX][nextY] && matrix[nextX][nextY] > matrix[x][y]){
                dfs(matrix,nextX,nextY,row,col,depth + 1);
            }

            res = Math.max(res,depth);
        }

        visited[x][y] = false;
    }

    public boolean isValid(int x,int y,int row,int col){
        return (x >= 0 && x < row) && (y >= 0 && y < col);
    }

    public static void main(String[] args) {
        NC138 nc138 = new NC138();
        int[][] matrix = {{1,2},{4,3}};

        int solve = nc138.solve(matrix);
        System.out.println(solve);
    }


}
