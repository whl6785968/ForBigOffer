package ArrayDemo;

import java.util.ArrayList;
import java.util.List;

public class Solution57_2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1,j = 2;

        List<List<Integer>> res = new ArrayList<>();
        int limit = (target - 1) / 2;
        while (j <= limit + 1){
            int cur_sum = sum(i,j);

            if(cur_sum < target){
                j++;
            }
            else if(cur_sum > target){
                i++;
            }
            else{
                List<Integer> tmp = new ArrayList<>();
                for(int k = i;k <= j;k++){
                    tmp.add(k);
                }

                res.add(tmp);

                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int sum(int i,int j){
        int sum = 0;
        for(int k = i;k <= j;k++){
            sum += k;
        }

        return sum;
    }


}
