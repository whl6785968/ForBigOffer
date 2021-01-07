package RuleDemo;

import java.util.HashSet;
import java.util.Set;

public class NC95 {
    public int MLS (int[] arr) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        int max_length = 0;

        for(int num : set){
            if(set.contains(num - 1)){
                continue;
            }
            else {
                int l = 0;
                while (set.contains(num)){
                    l++;
                    num++;
                }

                max_length = Math.max(l,max_length);
            }
        }

        return max_length;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};

        NC95 nc95 = new NC95();
        int mls = nc95.MLS(nums);
        System.out.println(mls);
    }
}
