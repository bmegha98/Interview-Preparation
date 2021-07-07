/*
Given two linked lists, the task is to complete the function findIntersection(), that returns the intersection of two linked lists. Each of the two linked list 
contains distinct node values.The order of nodes in this list should be same as the order in which those particular nodes appear in input list 1.

Example 1:

Input:
LinkedList1: 9->6->4->2->3->8
LinkedList2: 1->2->8->6
Output: 6 2 8
*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        
        Set<Integer> aux = new HashSet<>();
        while(head2 != null) {
            aux.add(head2.data);
            head2 = head2.next;
        }
        
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(head1 != null) {
            if(aux.contains(head1.data)) {
                res.next = head1;
                res = res.next;
            }
            head1 = head1.next;
        }
        res.next = null;
        return dummy.next;
    }
}
