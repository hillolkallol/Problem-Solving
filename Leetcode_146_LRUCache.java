/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
import java.util.*;
public class Leetcode_146_LRUCache {
    
}
class LRUCache {
    class DLinkedList {
        int val;
        int key;
        DLinkedList prev;
        DLinkedList next;
        public DLinkedList(int key, int value) {
            this.key = key;
            this.val = value;
            prev = null;
            next = null;
        }
    }
    
    Map<Integer, DLinkedList> map;
    int capacity;
    DLinkedList head;
    DLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedList(0, 0);
        tail = new DLinkedList(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(! map.containsKey(key)) return -1;
        bringToFront(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if(map.containsKey(key)) {
            map.get(key).val = value;
            bringToFront(map.get(key));
        }
        else {
            if (map.size() == capacity) {
                removeLeast();
            }
            DLinkedList newNode = new DLinkedList(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }
    
    void bringToFront(DLinkedList dll) {
        DLinkedList prev = dll.prev;
        DLinkedList next = dll.next;
        prev.next = next;
        next.prev = prev;
        addToFront(dll);
    }
    
    void removeLeast() {
        DLinkedList toRemove = head.next;
        map.remove(toRemove.key);
        DLinkedList next = toRemove.next;
        head.next = next;
        next.prev = head;
    }
    
    void addToFront(DLinkedList newNode) {
        DLinkedList oldFront = tail.prev;
        oldFront.next = newNode;
        newNode.next = tail;
        newNode.prev = oldFront;
        tail.prev = newNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
