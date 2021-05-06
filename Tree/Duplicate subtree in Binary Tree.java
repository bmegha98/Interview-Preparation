/*
Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

Example 1 :

Input : 
               1
             /   \ 
           2       3
         /   \       \    
        4     5       2     
                     /  \    
                    4    5

Output : 1
*/

class Solution {
    int res = 0;
    Map<String,Integer> aux = new HashMap<>();
    int dupSub(Node root) {
        // code here 
        if(root == null || (root.left == null && root.right == null))
            return 0;
        helper(root);
        return res;
    }
    
    private String helper(Node root) {
        if(root == null)
            return "#";
        String l = helper(root.left);
        String r = helper(root.right);
        String tmp = l+String.valueOf(root.data)+r;
        aux.put(tmp, aux.getOrDefault(tmp,0)+1);
        if(tmp.length() > 3 && aux.get(tmp) > 1)
            res = 1;
        return tmp;
    }
}
