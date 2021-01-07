package PriQueue;

import java.util.PriorityQueue;

public class NC88 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < n;i++){
            if(priorityQueue.size() < K){
                priorityQueue.add(a[i]);
            }
            else{
                if(a[i] > priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(a[i]);
                }
            }
        }


        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        NC88 nc88 = new NC88();
        int[] a = {1,3,5,2,2};
        int kth = nc88.findKth(a, 5, 3);
        System.out.println(kth);
    }
}
