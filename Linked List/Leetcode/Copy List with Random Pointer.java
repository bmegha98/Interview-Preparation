/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
*/

//Using hashmap, T(n) = O(n) , space = O(n)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        Node X= head,Y=null;
        LinkedHashMap<Node,Node> m = new LinkedHashMap<>();
        
        while(X != null)
        {
            Y = new Node(X.val);
            m.put(X,Y);
            X = X.next;
        }
        X = head;
        while(X != null)
        {
            Y = m.get(X);
            Y.next = m.get(X.next);
            Y.random = m.get(X.random);
            X = X.next;
        }
        return m.get(head);
    }
}

//T(n) = O(n) , space = O(1)

class Solution {
    public Node copyRandomList(Node head) 
    {
        if(head == null)
            return null;
        Node X = head,Y = null;
        while(X != null)
        {
            Y = new Node(X.val);
            Y.next = X.random;
            X.random = Y;
            X = X.next;
        }
        X = head;
        while(X != null)
        {
            Y = X.random;
            Y.random = (Y.next != null)?Y.next.random:null;
            X = X.next;
        }
        X = head;
        Node newHead = X.random;
        while(X != null)
        {
            Y = X.random;
            X.random = Y.next;
            Y.next = (X.next != null)?X.next.random:null;
            X = X.next;
        }
        return newHead;
    }
}
