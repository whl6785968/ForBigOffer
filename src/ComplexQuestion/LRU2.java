package ComplexQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class LRU2 {
    public int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int[] ops : operators){
            int op = ops[0];
            int key = ops[1];
            if(op == 1){
                int value = ops[2];
                if(map.size() < k){
                    map.put(key,value);
                }
                else{
                    Iterator<Integer> head = map.keySet().iterator();
                    map.remove(head.next());
                    map.put(key,value);
                }
            }
            else{

                if(map.containsKey(key)){
                    int value = map.get(key);
                    list.add(value);
                    map.remove(key);
                    map.put(key,value);
                }
                else{
                    list.add(-1);
                }
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
