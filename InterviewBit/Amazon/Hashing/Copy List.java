/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the
returned list should not link to any node in the original input list.
*/

//Using map , T(n) = O(n) , Space = O(n)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> aux = new HashMap<>();
        RandomListNode X = head, Y;
        while(X != null) {
            Y = new RandomListNode(X.label);
            aux.put(X,Y);
            X = X.next;
        }
        
        RandomListNode res = aux.get(head);
        X = head;
        while(X != null) {
            Y = aux.get(X);
            Y.next = aux.get(X.next);
            Y.random = aux.get(X.random);
            X = X.next;
        }
        return res;
    }
}

//Space-optimized
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode X = head, Y;
        while(X != null) {
            Y = new RandomListNode(X.label);
            Y.next = X.random;
            X.random = Y;
            X = X.next;
        }
        
        X = head;
        while(X != null) {
            Y = X.random;
            Y.random = Y.next != null ? Y.next.random : null;
            X = X.next;
        }
        
        X = head;
        RandomListNode res = X.random;
        while(X != null) {
            Y = X.random;
            X.random = Y.next;
            Y.next = X.next != null ? X.next.random : null;
            X = X.next;
        }
        
        return res;
    }
}
