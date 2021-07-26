/*
Merge k sorted linked lists and return it as one sorted list.
Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int k = a.size();
        if(k == 0)
            return null;
        if(k == 1)
            return a.get(0);
        
        Queue<ListNode> aux = new PriorityQueue<>(1,(p,q)->(p.val-q.val));
        
        for(int i=0;i<k;i++) {
            if(a.get(i) != null)
                aux.add(a.get(i));
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(!aux.isEmpty()) {
            ListNode curr = aux.poll();
            if(curr.next != null)
                aux.add(curr.next);
            res.next = curr;
            res = res.next;
        }
        
        return dummy.next;
    }
}
