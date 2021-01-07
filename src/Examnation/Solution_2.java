package Examnation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        while (cnt-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    arr[i][j] = sc.nextInt();
                    map.put(arr[i][j],map.getOrDefault(arr[i][j],0) + 1);
                }
            }

            int res = 0;
            for(int i = 0;i < n / 2;i++){
                for(int j = 0;j < m;j++){
                    if(arr[i][j] != arr[i][n-1-j] && arr[i][j] != arr[n-1-i][j]){
                        if(Math.abs(arr[i][j] - arr[i][n-1-j]) > Math.abs(arr[i][j] - arr[n-1-j][i])){
                            res += Math.abs(arr[i][j] - arr[n-1-j][i]);
                            arr[i][j] = arr[n-1-j][i];
                        }
                        else{
                            res += Math.abs(arr[i][j] - arr[i][n-1-j]);
                            arr[i][j] = arr[i][n-1-j];
                        }
                    }
                    else if(arr[i][j] != arr[i][n-1-j] && arr[i][j] == arr[n-1-i][j]){
                        res += Math.abs(arr[i][j] - arr[i][n-1-j]);
                        arr[i][j] = arr[i][n-1-j];
                    }
                    else if(arr[i][j] == arr[i][n-1-j] && arr[i][j] != arr[n-1-i][j]){
                        res += Math.abs(arr[i][j] - arr[n-1-i][j]);
                        arr[i][j] = arr[i][n-1-j];
                    }
                }
            }

            System.out.println(res);
        }
    }
}
