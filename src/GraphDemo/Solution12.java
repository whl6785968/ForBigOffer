package GraphDemo;

import java.util.Arrays;

public class Solution12 {

    public boolean flag;
    public boolean[][] visited;
    public int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        visited = new boolean[row][col];
        flag = false;

        for(int i = 0;i < row;i++){
            for(int j = 0; j < col;j++){
                if(!visited[i][j] && board[i][j] == word.charAt(0)){
                    recur(board,word,1,i,j,row,col);
                }

            }
        }

        return flag;
    }

    public void recur(char[][] board,String word,int depth,int i,int j,int row,int col){
        if(depth == word.length()){
            flag = true;
            return;
        }

        visited[i][j] = true;


        for(int d = 0;d < 4;d++){
            int nextX = i + dirs[d][0];
            int nextY = j + dirs[d][1];

            if(isValid(row,col,nextX,nextY) && !visited[nextX][nextY] && board[nextX][nextY] == word.charAt(depth)){
                recur(board,word,depth+1,nextX,nextY,row,col);
            }
        }

        visited[i][j] = false;
    }

    public boolean isValid(int row,int col,int m,int n){
        return (m >= 0 && m < row) && (n >= 0 && n < col);
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };

        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };

        String word = "AAB";

        Solution12 solution12 = new Solution12();
        boolean exist = solution12.exist(board, word);

        System.out.println(exist);
    }
}
