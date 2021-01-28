/*
Given a Linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f .. where a, b, c are consecutive data node of linked list 
and such that the order of linked list is sustained.
*/

class Solution{
    
    void swap(Node x,Node y)
    {
        int tmp = x.data;
        x.data = y.data;
        y.data = tmp;
    }
	public  Node zigZag(Node head){
        //add code here.
        Node curr = head;
        if(head == null || head.next == null)
            return head;
        int rel = 1;
        
        while(curr.next != null)
        {
            if(rel == 1)
            {
                if(curr.data > curr.next.data)
                    swap(curr,curr.next);
            }
            else
            {
                if(curr.data < curr.next.data)
                    swap(curr,curr.next);
            }
            rel = 1-rel;
            curr = curr.next;
        }
        return head;
    }
}
