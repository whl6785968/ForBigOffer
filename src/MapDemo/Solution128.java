package MapDemo;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num : nums){
            num_set.add(num);
        }

        int res = 0;

        for(int num : num_set){
            if(!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStep = 1;

                while (num_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStep += 1;
                }

                res = Math.max(res,currentStep);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int[] nums = {100,4,200,1,3,4,2};

        int i = solution128.longestConsecutive(nums);
        System.out.println(i);
    }
}
