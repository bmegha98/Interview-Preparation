/*
Given a linked list, you have to perform the following task:

Extract the alternative nodes from starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
*/

class GfG
{
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
    public void rearrange(Node head)
    {
        // add your code here
        if(head == null || head.next == null)
            return;
        Node first = new Node(-1),second = new Node(-1);
        Node odd = first,even = second;
        int count = 1;
        while(head != null)
        {
            if(count % 2 == 1)
            {
                odd.next = head;
                odd = odd.next;
            }
            else
            {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count++;
        }
        odd.next = null;
        even.next = null;
        second = reverse(second.next);
        odd.next = second;
        head= first.next;
    }
}
