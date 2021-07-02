/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
*/

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node mid = getMiddle(head);
        Node second = mid.next;
        mid.next = null;
        
        Node a = mergeSort(head);
        Node b = mergeSort(second);
        return mergeLists(a,b);
    }
   
    private static Node getMiddle(Node head) {
        Node slow = head,fast = head.next;
        while(fast != null) {
            fast = fast.next;
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    private static Node mergeLists(Node a, Node b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(a != null && b != null) {
            if(a.data <= b.data) {
                res.next = a;
                a = a.next;
            }
            else {
                res.next = b;
                b = b.next;
            }
            res = res.next;
        }
        if(a != null)
            res.next = a;
        else
            res.next = b;
        return dummy.next;
    }
}
