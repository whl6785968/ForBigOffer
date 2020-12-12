package StackDemo;

import java.util.LinkedList;

public class Solution09 {
    public LinkedList<Integer> A;
    public LinkedList<Integer> B;

    public Solution09() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {

        if(!B.isEmpty()){
            return B.removeLast();
        }

        if(!A.isEmpty()){
            while (!A.isEmpty()){
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
