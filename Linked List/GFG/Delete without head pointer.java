/*
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head 
node is not given. 
Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail node in the linked list.
*/

class GfG
{
    void deleteNode(Node node)
    {
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
