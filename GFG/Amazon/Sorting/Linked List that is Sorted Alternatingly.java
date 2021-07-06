/*
Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.
Example 1:

Input:
LinkedList: 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: After sorting the given
list will be 1-> 2-> 3-> 7-> 8-> 9.
 

Example 2:

Input:
LinkedList: 13->99->21->80->50
Output: 13 21 50 80 99
Explanation: After sorting the given list 
will be 13-> 21-> 50-> 80-> 99.

Input : 991->20->1000->19->1001->1
Output: 1->19->20->991->1000->1001
*/

class Solution {
    
    public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node asc = new Node(-1);
        Node desc = new Node(-1);
        Node ascHead = asc;
        Node descHead = desc;
        int i = 0;
        while(head != null) {
            if(i%2 == 0) {
                asc.next = head;
                asc = asc.next;
            }
            else {
                desc.next = head;
                desc = desc.next;
            }
            head = head.next;
            i++;
        }
        
        asc.next = null;
        desc.next = null;
        
        descHead = reverse(descHead.next);
        return mergeLists(ascHead.next,descHead);
    }
   
    private Node reverse(Node head) {
        Node curr = head,prev = null,aux;
        while(curr != null) {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
   
    private Node mergeLists(Node a, Node b) {
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
