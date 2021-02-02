//Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        //your code here
        if(head == null || M == 0)
        {
            head = null;
            return;
        }
        Node curr = head,aux;
        int i,j;
        while(curr != null)
        {
            for(i = 1;i<M&&curr != null;i++)
                curr = curr.next;
            if(curr == null)
                return;
            aux = curr.next;
            for(j = 1;j<=N&&aux!=null;j++)
                aux = aux.next;
            curr.next = aux;
            curr = curr.next;
        }
    }
}
