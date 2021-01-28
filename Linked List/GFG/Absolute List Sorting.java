/*
Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data. Sort the linked list according to the actual values.
Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
      Output: -5 -> -3 -> -2 -> 1 -> 4
*/

class GfG
{
	Node sortedList(Node head)
	{
		// Your code here
		if(head == null)
		    return null;
		Node p = head,q = head,aux,prev = null;
		while(q != null)
		{
		    aux = q.next;
		    if(q.data < 0 && prev != null)
		    {
		         prev.next = aux;
		         q.next = p;
		         p = q;
		     }
		     else
		        prev = q;
		     q = aux;
		}
		return p;
	}
}
