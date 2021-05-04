//Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    private static boolean areMirror(Node a, Node b) {
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return (a.data == b.data)&&areMirror(a.left,b.right)&&areMirror(a.right,b.left);
    }
    public static boolean isSymmetric(Node root)
    {
        // add your code here;
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return areMirror(root, root);
    }
}
