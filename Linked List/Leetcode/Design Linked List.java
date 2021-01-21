/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked
list are 0-indexed.

Implement the MyLinkedList class:
- MyLinkedList() Initializes the MyLinkedList object.
- int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
- void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the
linked list.
- void addAtTail(int val) Append a node of value val as the last element of the linked list.
- void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node
will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
- void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

*/

class MyNode
{
    int val;
    MyNode next;
    MyNode(int v ,MyNode ptr)
    {
        val = v;
        next = ptr;
    }
}
class MyLinkedList
{
    
    
    
    MyNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) 
    {
        MyNode curr = head;
        if(index < 0)
            return -1;
        if(index == 0)
            return curr.val;
        int i;
        for(i =0;i<index && curr != null;i++)
            curr = curr.next;
        if(i <= index && curr == null)
            return -1;
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        MyNode n = new MyNode(val,head);
       
        head = n;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) 
    {
        MyNode n = new MyNode(val,null);
        if(head == null)
        {
            head = n;
            return;
        }
        MyNode curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = n;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) 
    {
        if(index == 0)
        {
            addAtHead(val);
            return;
        }
        MyNode node = new MyNode(val,null);
        int i = 0;
        MyNode curr = head,prev = null;
        while(i < index && curr != null)
        {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(i < index && curr == null)
            return;
        
        prev.next = node;
        node.next = curr;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) 
    {
        if(index < 0)
            return;
        if(index == 0)
        {
            head = head.next;
            return;
        }
        MyNode curr = head,prev = null;
        int i =0;
        while(i < index && curr != null)
        {
            i++;
            prev = curr;
            curr = curr.next;
        }
        if(i <= index && curr == null)
            return;
        
         prev.next = curr.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
