package DpDemo;

import java.util.Arrays;

public class NC126 {
    public int minMoney (int[] arr, int aim) {
        // write code her
        int[] dp = new int[aim + 1];
        Arrays.fill(dp,aim+1);
        dp[0] = 0;

        for(int i = 1;i < aim + 1;i++){
            for(int coin : arr){
                if(i >= coin){
                    dp[i] = Math.min(dp[i],dp[i-coin] + 1);
                }
            }
        }

        return dp[aim] == Integer.MAX_VALUE ? -1 : dp[aim];
    }

    public static void main(String[] args) {
        NC126 nc126 = new NC126();
        int[] arr = {5,2,3};
        int i = nc126.minMoney(arr, 20);
        System.out.println(i);
    }
}
