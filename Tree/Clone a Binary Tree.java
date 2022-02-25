/*
Given a special binary tree having random pointers along with the usual left and right pointers. Clone the given tree.


Example 1:

Input:

Output: 1
Explanation: The tree was cloned successfully.

Your Task:
No need to read input or print anything. Complete the function cloneTree() which takes root of the given tree as input parameter and returns the root of the
cloned tree. 

Note: The output is 1 if the tree is cloned successfully. Otherwise output is 0.
*/

class Solution{
    Map<Tree, Tree> aux;
    public Tree cloneTree(Tree tree){
        // add code here.
        if(tree == null)
            return null;
        
        aux = new HashMap<>();
        constructMap(tree);
        
        for(Map.Entry<Tree,Tree> entry : aux.entrySet()) {
            Tree orig = entry.getKey(), clone = entry.getValue();
            clone.random = aux.get(orig.random);
        }
        return aux.get(tree);
    }
    
    private Tree constructMap(Tree root) {
        if(root == null)
            return null;
        Tree curr = new Tree(root.data);
        aux.put(root, curr);
        curr.left = constructMap(root.left);
        curr.right = constructMap(root.right);
        return curr;
    }
    
}
