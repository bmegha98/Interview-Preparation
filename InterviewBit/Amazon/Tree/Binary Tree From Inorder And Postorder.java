/*
Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return : 
            1
           / \
          2   3

*/

public class Solution {
    Map<Integer,Integer> aux = new HashMap<>();
    int pos;
    public TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
        int n = in.size();
        if(n == 0) return null;
        if(n == 1) return new TreeNode(in.get(0));
        
        for(int i=0;i<n;i++)
            aux.put(in.get(i),i);
        pos = n-1;
        return constructTree(in,post,0,n-1);
    }
    private TreeNode constructTree(ArrayList<Integer> in, ArrayList<Integer> post, int l,
        int h) {
        if(l > h) return null;
        TreeNode root = new TreeNode(post.get(pos));
        pos--;
        if(l == h)
            return root;
        int ind = aux.get(root.val);
        root.right = constructTree(in,post,ind+1,h);
        root.left = constructTree(in,post,l,ind-1);
        return root;
    }
}
