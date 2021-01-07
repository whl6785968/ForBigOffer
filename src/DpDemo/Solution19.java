package DpDemo;

public class Solution19 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for(int i = 0;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(p.charAt(j - 1) == '*'){
                    //不匹配，即字符串s是否和空串匹配
                    f[i][j] = f[i][j-2];

                    //匹配，例如aa和a*，若此时字符为*，看*号前的字符是否和s串末尾字符匹配
                    //若匹配继续向前看
                    //若不匹配肯定为false
                    if(matches(s,p,i,j-1)){
                        //看a*是否能和a匹配
                        //将问题简化为子问题
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                }
                else{
                    if(matches(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }

        return f[m][n];
    }

    public boolean matches(String s,String p,int i,int j){
        if(i == 0) return false;

        if(p.charAt(j - 1) == '.'){
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        String s = "aaa";
        String p = "a*";

        boolean match = solution19.isMatch(s, p);
        System.out.println(match);

    }
}
