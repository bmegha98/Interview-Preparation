/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

//Iterative
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            }
            else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if(list1 != null)
            res.next = list1;
        else
            res.next = list2;
        return dummy.next;
    }
}

//Recursive
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode res;
        if(list1.val <= list2.val) {
            res = list1;
            res.next = mergeTwoLists(list1.next,list2);
        }
        else {
            res = list2;
            res.next = mergeTwoLists(list1,list2.next);
        }
        return res;
    }
}
