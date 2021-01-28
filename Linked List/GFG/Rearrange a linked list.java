/*
Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even positions node are together.
Assume the first element to be at position 1 followed by second element at position 2 and so on.
*/

class gfg
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns new head of linked List.
    Node rearrangeEvenOdd(Node head)
    {
        //The task is to complete this method
        if(head == null || head.next == null)
            return head;
        Node oddPos = new Node(-1),evenPos = new Node(-1);
        Node oddHead = oddPos,evenHead = evenPos;
        int count = 1;
        while(head != null)
        {
            if(count%2 == 1)
            {
                oddPos.next = head;
                oddPos = oddPos.next;
            }
            else
            {
                evenPos.next = head;
                evenPos = evenPos.next;
            }
            head = head.next;
            count++;
        }
        evenPos.next = null;
        oddPos.next = evenHead.next;
        return oddHead.next;
    }
}
