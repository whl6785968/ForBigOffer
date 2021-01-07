package DpDemo;

public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int i = 0;i < coins.length;i++){
            for(int coin = coins[i];coin <= amount;coin++){
                dp[coin] += dp[coin-coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        int[] coins = {1,2,5};
        int change = solution518.change(5, coins);
        System.out.println(change);
    }
}
