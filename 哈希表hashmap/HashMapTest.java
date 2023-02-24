package 哈希表hashmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    

    public static void main(String[] args) throws Exception {
        HashMapTest test = new HashMapTest(2);
        test.put(1, 1);
        test.put(2, 2);
        int val;
        val = test.get(1);
        test.put(3, 3);
        val = test.get(2);

        System.out.println(val);
    }

   
    int capacity = 0;
    int size = 0;
    Map<Integer, LinkedNode> cache = new HashMap<>();
    LinkedNode fakeHead = new LinkedNode();
    LinkedNode fakeTail = new LinkedNode();

    //构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if(node == null){
            node = new LinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if(size > capacity){
                LinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }


    class LinkedNode{
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;
        //用于构造假节点
        public LinkedNode(){
        }
        public LinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public void addToHead(LinkedNode node){
        node.prev = fakeHead;
        node.next = fakeHead.next;
        //下面顺序不能反，否则fakeHead.next.prev会先发生变化
        fakeHead.next.prev = node;
        fakeHead.next = node;
    }

    public void removeNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(LinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public LinkedNode removeTail(){
        LinkedNode tail = fakeTail.prev;
        removeNode(tail);
        return tail;
    }
}


