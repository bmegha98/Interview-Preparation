/*
Given a sorted singly linked list and a data, your task is to insert the data in the linked list in a sorted way i.e. order of the list doesn't change.
*/

class Solution {
    Node sortedInsert(Node head, int key) {
        //Add your code here.
        Node n = new Node(key);
        if(head == null)
        {
            head = n;
            return head;
        }
        if(key <= head.data)
        {
            n.next = head;
            head=n;
            return head;
        }
        Node curr = head,prev = null;
        while(curr != null && curr.data < key)
        {
            prev = curr;
            curr = curr.next;
        }
        n.next = curr;
        if(prev != null)
            prev.next = n;
        return head;
    }
}
