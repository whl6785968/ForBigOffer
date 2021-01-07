package DpDemo;

public class NC92 {
    public String LCS (String s1, String s2) {
        // write code here
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "-1";

        int s1_index = s1.length() - 1;
        int s2_index = s2.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (s1_index >= 0 && s2_index >= 0){
            if(s1.charAt(s1_index) == s2.charAt(s2_index)){
                sb.append(s1.charAt(s1_index));
                s1_index--;
                s2_index--;
            }
            else{
                if(s1_index >= 1 && s2_index >= 1){
                    if(Math.max(s1.charAt(s1_index - 1),s2.charAt(s2_index))
                    >= Math.max(s1.charAt(s1_index),s2.charAt(s2_index-1))){
                        s2_index--;
                    }
                    else{
                        s1_index--;
                    }
                }
                else if(s1_index == 0){
                    s2_index--;
                }
                else {
                    s1_index--;
                }
            }
        }

        if(sb.length() == 0) return "-1";
        return sb.reverse().toString();
    }

    public String LCS2(String s1,String s2){
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "-1";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int s1_index = n;
        int s2_index = m;
        while (s1_index != 0 && s2_index != 0){
            if(s1.charAt(s1_index-1) == s2.charAt(s2_index-1)){
                sb.append(s1.charAt(s1_index-1));
                s1_index--;
                s2_index--;
            }
            else{
                if(dp[s1_index-1][s2_index] > dp[s1_index][s2_index-1]){
                    s1_index--;
                }
                else{
                    s2_index--;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        NC92 nc92 = new NC92();
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        String lcs = nc92.LCS2(s1, s2);
        System.out.println(lcs);
    }
}
