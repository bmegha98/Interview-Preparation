/*
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
*/

class Sol
{
    int carry = 1;
    public Node addOne(Node head) 
    { 
        //code here.
        helper(head);
        if(carry == 1)
        {
            Node n = new Node(1);
            n.next = head;
            head = n;
        }
        return head;
    }
    void helper(Node head)
    {
        if(head == null)
            return;
        helper(head.next);
        int s = head.data + carry;
        carry = s/10;
        s = s%10;
        head.data = s;
    }
}
