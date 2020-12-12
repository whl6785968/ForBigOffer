package DpDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int res = 0;
        int tmp = 0;
        for(int i = 0;i < s.length();i++){
            int j = map.getOrDefault(s.charAt(i),-1);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(tmp,res);
        }

        return res;

    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int abcabcbb = solution48.lengthOfLongestSubstring("dvdf");
        System.out.println(abcabcbb);
    }

}
