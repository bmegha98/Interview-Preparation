/*
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
*/

class GfG
{
    Node merge(Node a,Node b)
    {
        if(a == null)
            return b;
        if(b == null)
            return a;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(a != null && b != null)
        {
            if(a.data <= b.data)
            {
                res.bottom = a;
                a = a.bottom;
            }
            else
            {
                res.bottom = b;
                b = b.bottom;
            }
            res = res.bottom;
        }
        if(a != null)
            res.bottom = a;
        else
            res.bottom = b;
        return dummy.bottom;
    }
    Node flatten(Node root)
    {
	    // Your code here
	    if(root == null)
	        return null;
	    
	    while(root.next != null)
	    {
	        Node aux = root.next.next;
	        root = merge(root,root.next);
	        root.next = aux;
	    }
	    return root;
    }
}
