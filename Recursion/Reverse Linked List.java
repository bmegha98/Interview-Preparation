//Given the head of a singly linked list, reverse the list, and return the reversed list.

//Iterative T(n) = O(n), Space = O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
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

//Recursive T(n) = O(n), Space = O(n)

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode tmp = head.next;
        head.next = null;
        
        ListNode res = reverseList(tmp);
        tmp.next = head;
        return res;
    }
}
