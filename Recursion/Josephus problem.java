/*
Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.

The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining 
and survive.

Example 1:

Input:
n = 3 k = 2
Output: 3
Explanation: There are 3 persons so 
skipping 1 person i.e 1st person 2nd 
person will be killed. Thus the safe 
position is 3.
 

Example 2:

Input:
n = 5 k = 3
Output: 4
Explanation: There are 5 persons so 
skipping 2 person i.e 3rd person will 
be killed. Thus the safe position is 4.
*/

class ListNode {
    int val;
    ListNode next;
    public ListNode(int v) {
        val = v;
        next = null;
    }
}
class Solution
{
   public int josephus(int n, int k)
    {
        //Your code here
        ListNode p = new ListNode(1);
        ListNode q,head = p;
        for(int i=2;i<=n;i++) {
            q = new ListNode(i);
            p.next = q;
            p = p.next;
        }
        
        p.next = head;
        int count = n;
        
        while(count > 1) {
            for(int i=1;i<k;i++) 
                p = p.next;
            p.next = p.next.next;
            count--;
        }
        return p.val;
    }

}
