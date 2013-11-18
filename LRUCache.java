/**
 * LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already
 * present. When the cache reached its capacity, it should invalidate the
 * least recently used item before inserting a new item.
 * 
 * http://oj.leetcode.com/problems/lru-cache/
 */

class Node {
    Node pre = null;
    Node next = null;
    int key = 0;
    int val = 0;
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}


public class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    int used;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        used = 0;
        head = null;
        tail = null;
        map = new HashMap<Integer, Node>();
    }
    
        public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node != tail) {
                if (node == head) {
                    head.next.pre = null;
                    head = head.next;
                }
                else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
            return node.val;
        }
        else return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) { //overwrite the value
            this.get(key);
            map.get(key).val = value;
        }
        else { // find a new place to store it
            Node node = new Node(key, value);
            if (used == capacity) {
                map.remove(head.key);
                if (head.next != null) {
                    head.next.pre = null;
                    head = head.next;
                }

                tail.next = node;
                node.pre = tail;
                tail = node;
            }
            else {
                if (head == null) {
                    head = node;
                    tail = node;
                }
                else {
                    tail.next = node;
                    node.pre = tail;
                    tail = node;
                }
                used++;
            }
            map.put(key, node);
        }
    }
}
