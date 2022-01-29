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

//Iterative
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode first = head;
        ListNode second = getSecondPart(head);
        second = reverseList(second);
        while(second != null) {
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    private ListNode getSecondPart(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null) {
            fast = fast.next;
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
    private ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, aux;
        while(curr != null) {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
}
