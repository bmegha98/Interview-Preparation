/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros 
segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
*/

class LinkedList
{
    static Node segregate(Node head)
    {
        //add your code here
        if(head == null || head.next == null)
            return head;
        Node zero = new Node(-1),one = new Node(-1),two = new Node(-1);
        Node zeroHead = zero,oneHead = one,twoHead = two;
        while(head != null)
        {
            if(head.data == 0)
            {
                zero.next = head;
                zero = zero.next;
            }
            else if(head.data == 1)
            {
                one.next = head;
                one = one.next;
            }
            else
            {
                two.next = head;
                two = two.next;
            }
            head = head.next;
        }
        two.next = null;
        one.next = twoHead.next;
        zero.next = oneHead.next;
        return zeroHead.next;
    }
}
