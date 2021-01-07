package Examnation;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int solve = solution_1.solve("50");
        System.out.println(solve);
    }

    public int solve(String n){
        int num = Integer.valueOf(n);
        List<Integer> res = new ArrayList<>();
        if(n.length() == 1){
            return num;
        }
        else{
            outter:for(int i = 1;i <= 9;i++){
                for(int j = 0;j <= 9;j++){
                    if(i + j == num){
                        res.add(Integer.valueOf(i + "" + j));
                        break outter;
                    }
                }
            }
        }

        if(res.size() != 0){
            return res.get(0);
        }
        else{
            return -1;
        }
    }
}
