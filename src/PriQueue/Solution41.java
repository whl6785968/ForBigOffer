package PriQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution41 {
    Queue<Integer> A,B;

    public Solution41(){
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y) -> (y - x));
    }

    public void addNum(int num){
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }
        else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian(){
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
