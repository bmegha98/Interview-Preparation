/*
Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item
before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the 
oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 

Using Map and DLL
*/

class ListNode{
    int key,val;
    ListNode prev,next;
    public ListNode(int k,int v, ListNode p, ListNode n) {
        key = k;
        val = v;
        prev = p;
        next = n;
    }
}


public class Solution {
    Map<Integer,ListNode> aux;
    int capacity;
    ListNode head,tail;
    public Solution(int capacity) {
        aux = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(aux.containsKey(key)) {
            ListNode tmp = aux.get(key);
            int res = tmp.val;
            deleteNode(tmp);
            ListNode newTmp = addNodeToBack(tmp.key,res);
            aux.put(key,newTmp);
            return res;
        }
        else 
            return -1;
    }
    
    public void set(int key, int value) {
        if(aux.containsKey(key))
            deleteNode(aux.get(key));
        else{
            if(aux.size() == capacity) {
                int k = deleteFront();
                aux.remove(k);
            }
        }
        
        ListNode newTmp = addNodeToBack(key,value);
        aux.put(key,newTmp);
    }
    
    private void deleteNode(ListNode curr) {
        //System.out.println("deleted");
        if(head == curr) {
            if(tail == curr)
                tail = null;
            head = head.next;
            if(head != null)
                head.prev = null;
            return;
        }
        if(tail == curr) {
            if(head == curr)
                head = null;
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            return;
        }
        
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
    
    private int deleteFront() {
        //System.out.println("Front deleted");
        int res = head.key;
        if(head == tail) {
            tail = null;
            head = null;
            return res;
        }
        head = head.next;
        if(head != null)
            head.prev = null;
        return res;
    }
    
    private ListNode addNodeToBack(int k,int v) {
        //System.out.println("Node added");
        ListNode n = new ListNode(k,v,null,null);
        if(head == null) {
            head = n;
            tail = n;
            return head;
        }
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
        return tail;
    }
}
