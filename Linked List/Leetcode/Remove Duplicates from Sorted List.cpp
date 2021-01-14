//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

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
    ListNode* deleteDuplicates(ListNode* head) 
    {
        if(!head || !head->next)
            return head;
        ListNode *curr = head,*tmp;
        while(curr)
        {
            tmp = curr->next;
            while(tmp && tmp->val == curr->val)
            {
                ListNode* t = tmp;
                tmp = tmp->next;
                delete t;
            }
            curr->next = tmp;
            curr = curr->next;
        }
        return head;
    }
};
