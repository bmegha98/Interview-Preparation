/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary 
representation of a number.
Return the decimal value of the number in the linked list.
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
    int getDecimalValue(ListNode* head) 
    {
        int ans = 0;
        int pow = 0;
        helper(head,ans,pow);
        return ans;
    }
    void helper(ListNode* head,int& res,int& p)
    {
        if(!head)
            return;
        helper(head->next,res,p);
        res += head->val*pow(2,p);
        p++;
    }
};
