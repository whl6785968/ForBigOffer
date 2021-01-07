package DoubleIndexDemo;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NC82 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        int i = 0;
        int j = i + size - 1;
        int n = num.length;

        ArrayList<Integer> res = new ArrayList<>();

        while (j < n){
            res.add(getMax(num,i,j));
            i += 1;
            j += 1;
        }

        return res;
    }

    public int getMax(int[] num,int start,int end){
        int max = num[start];

        for(int i = start + 1;i <= end;i++){
            if(max < num[i]){
                max = num[i];
            }
        }

        return max;
    }

    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        //思路时=是，一个双向链表存储小标，当当前元素比下标小时，入队列，大时，遍历队列，比该元素小时就舍弃，然后入队列
        //begin记录滑动窗口左边
        ArrayList res= new ArrayList<>();
        if(num==null||size==0||num.length<size){
            return res;
        }
        int begin=0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            begin=i-size+1;//代表滑动窗口的起点
            if(queue.isEmpty()){
                queue.add(i);
            }
            else if(begin>queue.peekFirst()){
                //头部下表是否过期
                queue.pollFirst();
            }

            while(!queue.isEmpty()&&num[i]>= num[queue.peekLast()]){
                queue.pollLast();
            }

            queue.add(i);
            //是否形成size窗口
            if(begin>=0){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }

    public void test(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }

    public static void main(String[] args) {
        NC82 nc82 = new NC82();
        int[] nums = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> integers = nc82.maxInWindows2(nums, 3);
        System.out.println(integers);
//        nc82.test();
    }
}
