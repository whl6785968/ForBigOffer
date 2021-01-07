package MapDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NC61 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < numbers.length;i++){
            map.put(numbers[i],i);
        }

        int[] res = new int[2];
        for(int i = 0;i < numbers.length;i++){
            if(map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) > i){
                res[0] = i + 1;
                res[1] = map.get(target - numbers[i]) + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NC61 nc61 = new NC61();
        int[] numbers = {20,70,110,150};

        int[] ints = nc61.twoSum(numbers, 90);
        System.out.println(Arrays.toString(ints));
    }
}
