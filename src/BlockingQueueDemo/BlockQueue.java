package BlockingQueueDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private int size;
    private Object[] queue;

    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public BlockQueue(){
        this(10);
    }

    public BlockQueue(int size){
        this.size = size;
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        queue = new Object[size];
    }

    public void push(T element){
        lock.lock();
        try {
            while (currLen == size) {
                System.out.println("队列已满");
                full.await();
            }

            queue[index] = element;
            if(++index == size){
                index = 0;
            }

            currLen++;
            empty.signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();
        try{
            while (currLen == 0){
                System.out.println("队列为空");
                empty.await();
            }

            Object element = queue[removeIndex];

            if(++removeIndex == size){
                removeIndex = 0;
            }

            currLen--;
            full.signal();
            return (T) element;
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> queue = new BlockQueue<>();
        queue.push(1);
        System.out.println(queue.pop());
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
    }
}
