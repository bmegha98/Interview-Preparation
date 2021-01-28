/*
Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the distinct
elements only.
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    
	    TreeSet<Integer> s = new TreeSet<> ();
	        
	    while(head1 != null || head2 != null)
	    {
	        if(head1 != null)
	        {
	            s.add(head1.data);
	            head1 = head1.next;
	        }
	        if(head2 != null)
	        {
	            s.add(head2.data);
	            head2 = head2.next;
	        }
	    }
	    Node dummy = new Node(-1);
	    Node res = dummy;
	    for(Integer i : s)
	    {
	        res.next = new Node(i);
	        res = res.next;
	    }
	    return dummy.next;
	}
}
