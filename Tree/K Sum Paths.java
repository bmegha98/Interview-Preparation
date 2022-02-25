/*
Given a binary tree and an integer K. Find the number of paths in the tree which have their sum equal to K.
A path may start from any node and end at any node in the downward direction.


Example 1:

Input:      
Tree = 
          1                               
        /   \                          
       2     3
K = 3
Output: 2
Explanation:
Path 1 : 1 + 2 = 3
Path 2 : only leaf node 3
Example 2:

Input: 
Tree = 
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6    
K = 5                    
Output: 8
Explanation:
The following paths sum to K.  
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5 

Your Task:  
You don't need to read input or print anything. Complete the function sumK() which takes root node and integer K as input parameters and returns the number of
paths that have sum K. Since the answer may be very large, compute it modulo 109+7.
*/

class Solution
{
    int count = 0;
    Map<Integer,Integer> aux;
    public int sumK(Node root,int k)
    {
        // code here 
        if(root == null)
            return 0;
        aux = new HashMap<>();
        countSumPaths(root,k,0);
        return count;
    }
    
    private void countSumPaths(Node root, int target, int prefixSum) {
        if(root == null)
            return;
        prefixSum += root.data;
        if(prefixSum == target)
            count++;
        if(aux.containsKey(prefixSum-target))
            count += aux.get(prefixSum-target);
        
        aux.put(prefixSum, aux.getOrDefault(prefixSum,0)+1);
        
        countSumPaths(root.left,target,prefixSum);
        countSumPaths(root.right,target,prefixSum);
        
        aux.put(prefixSum, aux.get(prefixSum)-1);
    }
}
