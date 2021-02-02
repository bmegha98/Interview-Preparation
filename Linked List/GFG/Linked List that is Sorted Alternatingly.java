/*
Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.
*/

class Solution {
    
    
    Node reverse(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node curr = head,prev = null,aux;
        while(curr != null)
        {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
    public Node sort(Node head){
        //your code here, return the head of the sorted list
        if(head == null || head.next == null)
            return head;
        Node asc = new Node(-1),desc = new Node(-1);
        Node first = asc,second = desc;
        int count = 1;
        while(head != null)
        {
            if(count%2 == 1)
            {
                first.next = head;
                first = first.next;
            }
            else
            {
                second.next = head;
                second = second.next;
            }
            count++;
            head = head.next;
        }
        second.next = null;
        second = reverse(desc.next);
        first.next = null;
        first = asc.next;
        Node res = asc;
        while(first != null && second != null)
        {
            if(first.data <= second.data)
            {
                res.next = first;
                first = first.next;
            }
            else
            {
                res.next = second;
                second = second.next;
            }
            res = res.next;
        }
        if(first != null)
            res.next = first;
        else
            res.next = second;
        
        return asc.next;
   }


}
