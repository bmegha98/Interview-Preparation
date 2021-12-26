/*
Given a binary tree and two node values your task is to find the minimum distance between them.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 2
Explanation: The tree formed is:
       1
     /   \ 
    2     3
We need the distance between 2 and 3.
Being at node 2, we need to take two
steps ahead in order to reach node 3.
The path followed will be:
2 -> 1 -> 3. Hence, the result is 2. 
*/

class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = LCA(root,a,b);
        int d1 = getDist(lca,a);
        int d2 = getDist(lca,b);
        return d1+d2;
    }
    
    Node LCA(Node root, int a, int b) {
        if(root == null)
            return null;
        if(root.data == a || root.data == b)
            return root;
        Node l = LCA(root.left,a,b);
        Node r = LCA(root.right,a,b);
        
        if(l != null && r!=null)
            return root;
        return l!=null?l:r;
    }
    
    int getDist(Node curr,int ele) {
        if(curr == null)
            return -1;
        if(curr.data == ele)
            return 0;
        int l = getDist(curr.left,ele);
        if(l != -1)
            return l+1;
        int r = getDist(curr.right,ele);
        if(r == -1)
            return r;
        return r+1;
    }
}
