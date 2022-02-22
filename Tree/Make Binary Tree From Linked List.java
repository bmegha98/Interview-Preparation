/*
Given a Linked List Representation of Complete Binary Tree. The task is to construct the Binary tree.
Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i, its left, and right children are stored at
position 2*i+1, 2*i+2 respectively.
 
Example 1:

Input:
N = 5
K = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.
Example 2:

Input:
N = 5
K = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2    1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
Your Task:
The task is to complete the function convert() which takes head of linked list and root of the tree as the reference. The driver code prints the level order.


*/

class GfG 
{
    //Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        // add code here.
        Queue<Tree> aux = new LinkedList<>();
        aux.add(new Tree(head.data));
        
        head = head.next;
        if(head == null)
            return aux.peek();
        
        Tree root = null;    
        while(head != null) {
            Tree curr = aux.poll();
            if(root == null)
                root = curr;
            curr.left = new Tree(head.data);
            head = head.next;
            aux.add(curr.left);
            if(head != null) {
                curr.right = new Tree(head.data);
                aux.add(curr.right);
                head = head.next;
            }
        }
    
        return root;
    }
}
