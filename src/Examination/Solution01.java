package Examination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution01 {

    int cnt = 0;

    public int reletive_7 (int[] digit) {
        // write code here
        List<Integer> vector = new ArrayList<>();
        recur(digit,0,vector);
        return cnt;
    }

    public void recur(int[] digit,int index,List<Integer> vector){
        if(index == digit.length){
            String s = "";
            for(int num : vector){
                s += num;
            }

            int tmp = Integer.valueOf(s);

            if(tmp % 7 == 0){
                cnt += 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = index;i < digit.length;i++){
            swap(i,index,digit);
            vector.add(digit[index]);
            recur(digit,index + 1,vector);
            vector.remove(vector.size() - 1);
            swap(i,index,digit);
        }
    }

    public void swap(int i,int j,int[] digit){
        int tmp = digit[i];
        digit[i] = digit[j];
        digit[j] =  tmp;
    }

    public static void main(String[] args) {
        int[] digit = {1,1,2};
        Solution01 solution01 = new Solution01();
        int i = solution01.reletive_7(digit);
        System.out.println(i);
    }
}
