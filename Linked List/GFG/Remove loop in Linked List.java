/*
You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.
*/

class solver
{
    public static void removeLoop(Node head)
    {
        if(head == null || head.next == null)
            return;
        if(head.next == head)
        {
            head.next = null;
            return;
        }
        boolean isCycle = false;
        Node slow = head,fast = head,prev = null;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return;
        fast = head;
        while(slow != fast)
        {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(prev != null)
            prev.next = null;
    }
}
