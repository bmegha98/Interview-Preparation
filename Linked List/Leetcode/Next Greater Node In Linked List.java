/*
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible
choice.  If such a j does not exist, the next larger value is 0.
Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node
value of 1, and third node value of 5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public int[] nextLargerNodes(ListNode head) 
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        ListNode curr = head;
        while(curr != null)
        {
            l.add(curr.val);
            curr = curr.next;
        }
        int n = l.size();
        Stack<Integer> s = new Stack<Integer>();
        
        int res[] = new int[n];
        for(int i = n-1;i>=0;i--)
        {
            while(!s.empty() && l.get(s.peek()) <= l.get(i))
                s.pop();
            res[i] = s.empty()?0:l.get(s.peek());
            s.push(i);
        }
        return res;
    }
}
