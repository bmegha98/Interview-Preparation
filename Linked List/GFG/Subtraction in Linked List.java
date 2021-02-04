/*
Given two linked lists that represent two large positive numbers. The task is to subtract the given two numbers represented by the linked list. Subtract the
smaller from the larger one.
*/

class Solution
{
    int carry = 0;
    int getLength(Node head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
    Node appendZeros(Node head,int count)
    {
        if(head == null || count == 0)
            return head;
        Node zero = new Node(0);
        Node res = zero;
        for(int i=1;i<count;i++)
        {
            zero.next = new Node(0);
            zero = zero.next;
        }
        zero.next = head;
        return res;
    }
    
    boolean isBigger(Node l1,Node l2)
    {
        while(l1 != null && l2 != null && l1.data == l2.data)
        {
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null)
            return true;
        if(l1.data > l2.data)
            return true;
        return false;
    }
    void subtraction(Node l1,Node l2)
    {
        if(l1 == null || l2 == null)
            return;
        subtraction(l1.next,l2.next);
        l1.data -= carry;
        if(l1.data < l2.data)
        {
            l1.data += 10;
            carry = 1;
        }
        else
            carry = 0;
        l1.data -= l2.data;
    }
    Node subLinkedList(Node l1, Node l2)
    {
        // code here
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int m = getLength(l1),n = getLength(l2);
        if(m < n)
            l1 = appendZeros(l1,n-m);
        else if(m > n)
            l2 = appendZeros(l2,m-n);
        
        if(isBigger(l1,l2))
        {
            subtraction(l1,l2);
           
            while(l1.next != null && l1.data == 0)
                l1 = l1.next;
            return l1;
        }
        else
        {
            subtraction(l2,l1);
            
            while(l2.next!= null && l2.data == 0)
                l2 = l2.next;
            return l2;
        }
    }
}
