//Given the head of a singly linked list, return true if it is a palindrome.

class Solution {
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        left = head;
        return helper(head);
    }
    
    private boolean helper(ListNode right) {
        if(right == null)
            return true;
        boolean res = helper(right.next);
        if(!res)
            return res;
        res = left.val == right.val;
        left = left.next;
        return res;
    }
}
