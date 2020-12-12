package ArrayDemo;

public class Solution04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        int i = 0;
        int j = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while (i < row || j < col){
            if(target == matrix[i][j]){
                flag = true;
                break;
            }
            else if(target > matrix[i][j]){
                int A = Integer.MAX_VALUE;
                int B = Integer.MAX_VALUE;
                if(isValid(row,col,i+1,j) && target >= matrix[i+1][j]){
                    A = Math.abs(target - matrix[i+1][j]);
                }

                if(isValid(row,col,i,j+1) && target >= matrix[i][j+1]){
                    B = Math.abs(target - matrix[i][j+1]);
                }

                if(A < B){
                    i += 1;
                }
                else{
                    j += 1;
                }
            }
            else{
                break;
            }
        }

        return flag;
    }

    public boolean isValid(int row,int col,int m,int n){
        return (m >= 0 && m < row) && (col >= 0 && n < col);
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1,j = 0;

        while (i >= 0 && j < matrix.length){
            if(matrix[i][j] > target){
                i--;
            }
            else if(matrix[i][j] < target){
                j++;
            }
            else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Solution04 solution04 = new Solution04();
        boolean numberIn2DArray = solution04.findNumberIn2DArray(matrix, 5);
        System.out.println(numberIn2DArray);
    }

}
