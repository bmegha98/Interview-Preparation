/*
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node 
which appeared first should be kept, all others duplicates are to be removed.
*/

class GfG
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
        // Your code here
        if(head == null || head.next == null)
            return head;
        Set<Integer> s = new HashSet<>();
        Node curr = head,prev = null;
        while(curr != null)
        {
            if(s.contains(curr.data))
                prev.next = curr.next;
            else
            {
                s.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
