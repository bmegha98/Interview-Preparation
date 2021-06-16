/*
You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.
Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it successfully, the answer will be 1. 
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        
        if(head == null || head.next == null)
            return;
        if(head.next == head) {
            head.next = null;
            return;
        }
        
        boolean isCycle = false;
        Node slow = head,fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return;
        Node prev = null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        if(prev != null)
            prev.next = null;
        else {
            while(fast.next != slow) 
                fast = fast.next;
            fast.next = null;
        }
        
    }
}
