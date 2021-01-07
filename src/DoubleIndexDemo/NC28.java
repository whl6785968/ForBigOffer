package DoubleIndexDemo;

import java.util.HashMap;
import java.util.Map;

public class NC28 {
    public String minWindow (String S, String T) {
        // write code here
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(int i = 0;i < T.length();i++){
            need.put(T.charAt(i),need.getOrDefault(T.charAt(i),0) + 1);
        }

        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < S.length()){
            char temp = S.charAt(right);

            if(need.containsKey(temp)){
                window.put(temp,window.getOrDefault(temp,0) + 1);
                if(need.get(temp).compareTo(window.get(temp)) == 0){
                    count++;
                }
            }

            right++;

            while (count == need.size()){
                if(minLength > right - left){
                    start = left;
                    end = right;
                    minLength = right - left;
                }

                char c = S.charAt(left);

                if(need.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0) - 1);
                    if(need.get(c).compareTo(window.get(c)) > 0){
                        count--;
                    }

                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : S.substring(start,end);
    }

    public static void main(String[] args) {
        NC28 nc28 = new NC28();
        String S = "XDOYEZODEYXNZ";
        String T = "XYZ";
        String s = nc28.minWindow(S, T);
        System.out.println(s);
    }
}
