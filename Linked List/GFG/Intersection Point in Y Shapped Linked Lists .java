/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
*/

class Intersect
{
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
	int intersectPoint(Node head1, Node head2)
	{
        // code here
        if(head1 == null || head2 == null)
            return -1;
        int m = getLength(head1),n = getLength(head2);
        int diff = Math.abs(m-n);
        if(m>n)
        {
            while(diff-- > 0)
                head1 = head1.next;
        }
        else
        {
            while(diff-- > 0)
                head2 = head2.next;
        }
        while(head1 != null && head2 != null)
        {
            if(head1 == head2)
                return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
	}
}
