/*
Given a singly linked list containing N nodes. Modify the value of first half nodes such that 1st node’s new value is equal to the last node’s value minus first 
node’s current value, 2nd node’s new value is equal to the second last node’s value minus 2nd node’s current value, likewise for first half nodes. If n is odd then the value of the middle node remains unchanged.
Note: Input in the linked list is like new node will be entered at the head position (1st position).
*/

class Solution {
    
    Node getMiddle(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node slow = head,fast = head.next;
        while(fast != null)
        {
            fast = fast.next;
            if(fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    Node reverse(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node curr = head,prev=null,aux;
        while(curr != null)
        {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
    public Node modify(Node head){
        
        if(head == null || head.next == null)
            return head;
        Node mid = getMiddle(head);
        Node s = mid.next;
        mid.next = null;
        
        s = reverse(s);
        Node f = head,tmp = s;
        while(s != null)
        {
            f.data = f.data-s.data;
            s = s.next;
            f = f.next;
        }
        mid.next = reverse(tmp);
        return head;
    }
    public void show(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
