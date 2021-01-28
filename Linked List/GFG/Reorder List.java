/*
Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.
*/

class gfg {
    
    Node getMiddle(Node head)
    {
        if(head==null||head.next == null)
            return head;
        Node fast = head.next,slow = head;
        while(fast != null)
        {
            fast = fast.next;
            if(fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        Node res = slow.next;
        slow.next = null;
        return res;
    }
    Node reverse(Node head)
    {
        if(head==null||head.next == null)
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
    Node reorderlist(Node head) 
    {
        // Your code here
        if(head == null || head.next == null)
            return head;
        Node mid = getMiddle(head);
        mid = reverse(mid);
        Node dummy = new Node(-1);
        Node res = dummy;
        while(mid != null)
        {
            res.next = head;
            res = res.next;
            head = head.next;
            res.next = mid;
            res = res.next;
            mid = mid.next;
        }
        res.next = head;
        return dummy.next;
    }
}
