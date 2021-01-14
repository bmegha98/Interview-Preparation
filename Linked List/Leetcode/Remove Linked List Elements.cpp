/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) 
    {
        if(!head)
            return NULL;
        
        if(!head->next)
        {
            if(head->val == val)
            {
                delete head;
                head = NULL;
            }
            return head;
        }
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode *curr = head,*prev = dummy,*aux;
        while(curr)
        {
            aux = curr->next;
            if(curr->val == val)
            {
                delete curr;
                prev->next = aux;
            }
            else
                prev = curr;
            curr = aux;
        }
        head = dummy->next;
        delete dummy;
        return head;
    }
};
