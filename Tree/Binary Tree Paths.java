//Given the root of a binary tree, return all root-to-leaf paths in any order.A leaf is a node with no children.

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        if(root.left == null && root.right == null)
        {
            res.add(String.valueOf(root.val));
            return res;
        }
        findPaths(root, "");
        return res;
    }
    private void findPaths(TreeNode root, String path) {
        if(root == null)
            return;
        path += (String.valueOf(root.val)+"->");
        if(root.left == null && root.right == null) {
            path = path.substring(0, path.length()-2);
            res.add(path);
            return;
        }
        findPaths(root.left, path);
        findPaths(root.right, path);
    }
}
