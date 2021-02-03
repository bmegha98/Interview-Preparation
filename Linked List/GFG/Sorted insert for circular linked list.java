/*
Given a sorted circular linked list, the task is to insert a new node in this circular list so that it remains a sorted circular linked list.
*/

class GfG
{
	public static Node sortedInsert(Node head,int data)
    {
        //add code here.
        Node n = new Node(data);
        n.next = n;
        if(head == null)
        {
            head = n;
            return head;
        }
        Node curr = head,prev=null;
        if(head.data >= data)
        {
            n.next = head;
            while(curr.next != head)
                curr = curr.next;
            curr.next = n;
            head = n;
            return head;
        }
        
        do
        {
            prev = curr;
            curr = curr.next;
        }
        while(curr != head && curr.data < data);
        if(prev != null)
            prev.next = n;
        n.next = curr;
        return head;
    }
}
