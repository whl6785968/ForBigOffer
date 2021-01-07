package PriQueue;

import java.util.*;

public class NC97 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        TreeMap<String,Integer> map = new TreeMap<>();

        for(String str : strings){
            map.put(str,map.getOrDefault(str,0) + 1);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        String[][] res = new String[k][2];

        for(int i = 0;i < k;i++){
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }

        return res;

    }

    public static void main(String[] args) {
        NC97 nc97 = new NC97();
        String[] strs = {"1","1","2","3"};

        String[][] strings = nc97.topKstrings(strs, 2);
        for(String[] st: strings){
            System.out.println(Arrays.toString(st));
        }
    }
}
