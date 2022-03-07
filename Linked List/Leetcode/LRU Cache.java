/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the 
capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

class ListNode {
    int key,value;
    ListNode next,prev;
    public ListNode(int k,int v) {
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}

class LRUCache {

    Map<Integer,ListNode> aux;
    int limit;
    ListNode head,tail;
    public LRUCache(int capacity) {
        aux = new HashMap<>();
        limit = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!aux.containsKey(key))
            return -1;
        int v = aux.get(key).value;
        removeFromList(aux.get(key));
        ListNode updated = appendNode(key,v);
        aux.put(key,updated);
        return v;
    }
    
    public void put(int key, int value) {
        if(aux.containsKey(key)) {
            removeFromList(aux.get(key));
        }
        else if(aux.size() >= limit) {
            ListNode node = removeFromFront();
            aux.remove(node.key);
        }
        ListNode updated = appendNode(key,value);
        aux.put(key,updated);
    }
    
    private ListNode appendNode(int k, int v) {
        ListNode curr = new ListNode(k,v);
        if(head == null) {
            head = curr;
            tail = curr;
            return head;
        }
        tail.next = curr;
        curr.prev = tail;
        tail = tail.next;
        return tail;
    }
    
    private ListNode removeFromFront() {
        ListNode res = head;
        head = head.next;
        if(head != null)
            head.prev = null;
        else
            tail = null;
        return res;
    }
    
    private void removeFromList(ListNode curr) {
        if(curr == null) return;
        if(head == curr) {
            head = head.next;
            if(head != null)
                head.prev = null;
            else
                tail = null;
            return;
        }
        
        if(tail == curr) {
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            else
                head = null;
            return;
        }
        
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
