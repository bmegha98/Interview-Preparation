//Given a singly linked list, determine if it is a palindrome.

//T(n) = O(n) , Space = O(n)
class Solution {
public:
    bool isPalindrome(ListNode* head) 
    {
        if(!head || !head->next)
            return 1;
        return helper(head,head);
    }
    bool helper(ListNode*& left,ListNode* right)
    {
        if(!right)
            return 1;
        bool res = helper(left,right->next);
        if(!res)
            return 0;
        res = left->val == right->val?1:0;
        left = left->next;
        return res;
    }
};

//T(n) = O(n),space = O(1)

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
    void getMiddle(ListNode* head,ListNode*& f,ListNode*& s)
    {
        if(!head || !head->next)
        {
            f = head;
            return;
        }
        ListNode *slow = head,*fast = head->next;
        while(fast)
        {
            fast = fast->next;
            if(fast)
            {
                slow = slow->next;
                fast = fast->next;
            }
        }
        f = head;
        s = slow->next;
        slow->next = NULL;
    }
    ListNode* reverse(ListNode* head)
    {
        if(!head || !head->next)
            return head;
        ListNode *curr = head,*prev = NULL,*aux;
        while(curr)
        {
            aux = curr->next;
            curr->next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) 
    {
        if(!head || !head->next)
            return 1;
        ListNode *first = NULL,*second = NULL;
        getMiddle(head,first,second);
        second = reverse(second);
        while(second)
        {
            if(first->val != second->val)
                return 0;
            first = first->next;
            second = second->next;
        }
        return 1;
    }
   
};
