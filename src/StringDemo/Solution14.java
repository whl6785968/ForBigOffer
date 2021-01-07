package StringDemo;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i += 1;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println("flow".indexOf("flow"));

//        Solution14 solution14 = new Solution14();
//        String[] strs = {"flower","flow","flight"};
//
//        String s = solution14.longestCommonPrefix(strs);
//        System.out.println(s);
    }
}
