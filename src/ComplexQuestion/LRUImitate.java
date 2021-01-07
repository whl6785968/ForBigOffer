package ComplexQuestion;

public class LRUImitate {
    public int[] LRU (int[][] operators, int k) {

        return null;
    }


}

class LRUCache2{

    Node lruHead;
    Node lruTail;
    int size;
    Node[] hashtable;
    Node eliminateNode;
    int capacity;

    public LRUCache2(int k){
        hashtable = new Node[(int) (k / 0.75)];
        this.capacity = k;
    }

    public void set(int key,int value){
        int index = hash(key);
        Node node = hashtable[index];

        while (node != null && node.key != key){
            node = node.hashLink;
        }

        if(node != null){
            int oldValue = node.value;
            node.value = value;
            touch(node);
        }

        if(eliminateNode == null){
            node = new Node();
        }
        else{

        }

        node.key = key;
        node.value = value;
        node.hashLink = hashtable[index];
        hashtable[index] = node;

        if(size++ == 0){
            lruTail = node;
            lruHead = node;
        }
        else{
            node.pre = lruTail;
            lruTail.next = node;
            lruTail = node;
        }

    }

    public Integer get(int key){
        int index = hash(key);
        Node node = hashtable[index];

        while (node != null && node.key != key){
            node = node.hashLink;
        }

        if(node == null) return null;

        //将该节点变为最近用过的节点
        touch(node);

        int value = node.value;
        return value;
    }

    public void remove(){
        Node node = lruHead;
        if(node == null) return;

        lruHead = node.next;
        lruHead.pre = null;
        node.next = null;

        size--;

    }

    //将节点变为最近用过的节点，放在队列最后
    public void touch(Node node){
        //如果已经是队尾了，就不需要做其他操作了
        if(node.next == null) return;

        //如果节点为头部
        if(node.pre == null){
            lruHead = node.next;
            lruHead.pre = null;
        }
        else {
            //如果节点不为头部
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        node.next = null;
        node.pre = lruTail;
        lruTail.next = node;
        lruTail = node;

    }

    public int hash(int key){
        return (key < 0 ? -key : key) % hashtable.length;
    }

    static class Node{
        int key;
        int value;
        Node hashLink;
        Node pre;
        Node next;
    }
}