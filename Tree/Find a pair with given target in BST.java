/*
Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 

Example 1:

Input:
        2
      /   \
     1     3
sum = 5
Output: 1 
Explanation: 
Nodes with value 2 and 3 sum up to 5.
Example 2:

Input:
           6
          /    
         5     
        /
       3 
     /  \
    1    4
sum = 2
Output: 0 
Explanation: 
There's no pair that sums up to 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isPairPresent() that takes a root node and a target value as a parameter
and returns 1 if there's a pair of Nodes in the BST with values summing up to the target sum, else returns 0. 
*/

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        if(root == null)
            return 0;
        List<Integer> res = new ArrayList<>();
        Stack<Node> aux = new Stack<>();
        while(true) {
            while(root != null) {
                aux.push(root);
                root = root.left;
            }
            if(aux.isEmpty())
                break;
            root = aux.pop();
            res.add(root.data);
            root = root.right;
        }
        
        int l = 0, h = res.size()-1;
        while(l<h) {
            int sum = res.get(l)+res.get(h);
            if(sum == target)
                return 1;
            if(sum < target)
                l++;
            else
                h--;
        }
        return 0;
    }
}
