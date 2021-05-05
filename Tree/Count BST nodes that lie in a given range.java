/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
The values smaller than root go to the left side
The values greater and equal to the root go to the right side
*/

class Tree
{
    int res = 0;
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            if(l <= root.data && root.data <= h)
                return 1;
            return 0;
        }
        
        countHelper(root,l,h);
        return res;
    }
    
    private void countHelper(Node root, int l, int r) {
        if(root == null) return;
        if(l <= root.data && root.data <= r)
            res++;
        if(root.data <= l)
            countHelper(root.right, l, r);
        else if(root.data >= r)
            countHelper(root.left, l, r);
        else {
            countHelper(root.left, l, r);
            countHelper(root.right, l, r);
        }
    }
}
