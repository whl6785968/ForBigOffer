package DpDemo;

public class Solution91 {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;

        int n = s.length();

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i <= n;i++){
            String tmp = s.substring(i-2,i);

            if(s.charAt(i-1) == '0' && s.charAt(i-2) != '1' && s.charAt(i-2) != '2'){
                return 0;
            }
            else if(tmp.equals("20") || tmp.equals("10")){
                dp[i] = dp[i-2];
            }
            else if(tmp.compareTo("10") > 0 && tmp.compareTo("26") <= 0){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int i = solution91.numDecodings("10");
        System.out.println(i);
    }
}
