package HeapDemo;

import java.util.*;

public class TopK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0 || k > input.length) return new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num : input){
            if(priorityQueue.size() < k){
                priorityQueue.offer(num);
            }
            else{
                if(num < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }


        LinkedList<Integer> list = new LinkedList<>();
        while (!priorityQueue.isEmpty()){
            list.addFirst(priorityQueue.peek());
            priorityQueue.poll();
        }

        ArrayList<Integer> res = new ArrayList<>(list);
        return res;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] input = { 4,5,1,6,2,7,3,8 };
        int k = 4;

        ArrayList<Integer> integers = topK.GetLeastNumbers_Solution(input, k);
        System.out.println(integers);
    }

}
