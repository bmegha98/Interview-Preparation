/*
Given a Singly Linked List which has data members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data members as the given
Linked List.
Note: There might be nodes with same value.

Example 1:

Input:
Linked List: 1->2->3->4->5->6->7
Output:
4 2 1 3 6 5 7
Explanation :
The BST formed using elements of the 
linked list is,
        4
      /   \
     2     6
   /  \   / \
  1   3  5   7  
Hence, preorder traversal of this 
tree is 4 2 1 3 6 5 7
Example 2:

Input:
Linked List : 1->2->3->4
Ouput:
3 2 1 4
Exaplanation:
The BST formed using elements of the 
linked list is,
      3   
    /  \  
   2    4 
 / 
1
Hence, the preorder traversal of this 
tree is 3 2 1 4
Your task :
You don't have to read input or print anything. Your task is to complete the function sortedListToBST(), which takes head of the linked list as an input
parameter and returns the root of the BST created.
*/

//T(n) = O(nlogn), Space = O(logn)

class Solution
{
    public TNode sortedListToBST(LNode head)
    {
        //code here
        if(head == null)
            return null;
        LNode mid = getMiddle(head);
        TNode root = new TNode(mid.data);
        if(head.next == null)
            return root;
        LNode left = head;
        while(left.next != mid)
            left = left.next;
        
        left.next = null;
        if(head == mid)
            head = null;
        LNode right = mid.next;
        mid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);
        return root;
    }
    
    private LNode getMiddle(LNode head) {
        LNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

//T(n) = O(n), Space = O(logn)
class Solution
{
    private LNode tmp;
    private int countNodes(LNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    public TNode sortedListToBST(LNode head)
    {
        //code here
        if(head == null)
            return null;
        int n = countNodes(head);
        tmp = head;
        return helper(0,n-1);
    }
    
    private TNode helper(int l, int h) {
        if(l>h)
            return null;
        int m = (l+h+1)/2;
        TNode left = helper(l,m-1);
        TNode root = new TNode(tmp.data);
        tmp = tmp.next;
        root.left = left;
        TNode right = helper(m+1,h);
        root.right = right;
        return root;
    }
}
