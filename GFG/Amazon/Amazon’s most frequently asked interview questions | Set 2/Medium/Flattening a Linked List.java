/*
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->20->22->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
*/

class GfG
{
    Node flatten(Node root)
    {
	    // Your code here
	    if(root == null || root.next == null)
	        return root;
	    
	    Node flattenList = null;
	    while(root != null && root.next != null) {
	        Node dummy = new Node(-1);
	        Node res = dummy;
	        Node curr = root, second = root.next;
	        Node aux = root.next.next;
	        curr.next = null;
	        while(curr != null && second != null) {
	            if(curr.data <= second.data) {
	                res.bottom = curr;
	                curr = curr.bottom;
	            }
	            else {
	                res.bottom = second;
	                second = second.bottom;
	            }
	            res = res.bottom;
	        }
	        if(curr != null)
	            res.bottom = curr;
	        else
	            res.bottom = second;
	        root = dummy.bottom;
	        root.next = aux;
	    }
	    return root;
    }
}
