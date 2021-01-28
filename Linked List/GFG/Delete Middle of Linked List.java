/*
Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 
then it should be modified to 1->2->3->5->6.
If the input linked list is NULL or has 1 node, then it should return NULL
*/

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head == null || head.next == null)
            return null;
        Node slow = head,fast = head,prev = null;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev == null)
            head = head.next;
        else
            prev.next = slow.next;
        return head;
    }
}
