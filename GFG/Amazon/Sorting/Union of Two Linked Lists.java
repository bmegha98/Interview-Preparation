/*
Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the distinct 
elements only.
Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 1 2 3 4 6 8 9
Your Task:
The task is to complete the function makeUnion() which makes the union of the given two lists and returns the head of the new list.
Note: The new list formed should be in non-decreasing order.
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    Set<Integer> aux = new TreeSet<>();
	    while(head1 != null) {
	        aux.add(head1.data);
	        head1 = head1.next;
	    }
	    while(head2 != null) {
	        aux.add(head2.data);
	        head2 = head2.next;
	    }
	    
	    Node dummy = new Node(-1);
	    Node res = dummy;
	    
	    for(Integer i : aux) {
	        Node n = new Node(i);
	        res.next = n;
	        res = res.next;
	    }
	    return dummy.next;
	}
}
