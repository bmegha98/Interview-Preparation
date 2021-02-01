/*
Given two linked lists, your task is to complete the function mergeList() which inserts nodes of second list into first list at alternate positions of first list.
For each test case first print space separated vales of the first linked list, then in the next line print space separated values of the second linked list.
*/

class Solution {
    
    public void mergeAlt(Node head1, Node head2)
    {
        //write your code here, and print the result
        if(head1 == null)
        {
            head1=head2;
            return;
        }
        if(head2 == null)
            return;
        if(head2 == null)
            return;
        
        Node dummy = new Node(-1);
        Node res = dummy;
        while(head1 != null && head2 != null)
        {
            res.next = head1;
            head1 = head1.next;
            res = res.next;
            res.next = new Node(head2.data);
            head2 = head2.next;
            res = res.next;
        }
        if(head1 != null)
            res.next = head1;
        
        head1 = dummy.next;
        
        while(dummy.next != null)
        {
            System.out.print(dummy.next.data +" ");
            dummy = dummy.next;
        }
        System.out.println();
        while(head2 != null)
        {
            System.out.print(head2.data+" ");
            head2 = head2.next;
        }
    }
}
