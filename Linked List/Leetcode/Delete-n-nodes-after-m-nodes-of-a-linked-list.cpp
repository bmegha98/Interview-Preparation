/*
Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the 
linked list.
Difficulty Level: Rookie
Examples:
Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6
*/

ListNode* skipAndDeleteNodes(ListNode* head,int m,int n)
{
    if(!head)
        return NULL;
          
    ListNode *curr = head,*tmp;
    while(curr)
    {
        int i = 1;
        while(i<m && curr)
        {
            i++;
            curr = curr->next;
        }
        if(!curr)
            return head;
        tmp = curr->next;
        int j = 1;
        
        while(j<=n && tmp)
        {
            j++;
            ListNode* t = tmp;
            tmp = tmp->next;
            delete t;
        }
        curr->next = tmp;
        curr = tmp;
    }
    return head;
}
