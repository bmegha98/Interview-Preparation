/*
We are given a binary tree (with root node root), a target node, and an integer value k.
Return a list of the values of all nodes that have a distance k from the target node.  The answer can be returned in any order.
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: 
The nodes that are a distance 2 from the target node (with value 5)have values 7, 4, and 1.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Using DFS + BFS , T(n) = O(n), Space = O(n)
class Solution {
    Map<TreeNode,TreeNode> parent;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(k == 0) {
            res.add(target.val);
            return res;
        }
        parent = new HashMap<>();
        visited = new HashSet<>();
        dfs(root, null);
        
        Queue<Pair<TreeNode,Integer>> aux = new LinkedList<>();
        
        TreeNode curr = target;
        while(curr != null && k >= 0) {
            int dist = k;
            aux.add(new Pair<>(curr,0));
            visited.add(curr);
            while(!aux.isEmpty()) {
                Pair<TreeNode,Integer> p = aux.poll();
                TreeNode tmp = p.getKey();
                int d = p.getValue();
                if(d == dist)
                    res.add(tmp.val);
                else {
                    if(tmp.left != null && !visited.contains(tmp.left)) {
                        aux.add(new Pair<>(tmp.left,d+1));
                        visited.add(tmp.left);
                    }
                    if(tmp.right != null && !visited.contains(tmp.right)) {
                        aux.add(new Pair<>(tmp.right,d+1));
                        visited.add(tmp.right);
                    }
                }
            }
            
            curr = parent.get(curr);
            k--;
        }
        return res;
    }
    
    private void dfs(TreeNode curr, TreeNode par) {
        if(curr == null)
            return;
        parent.put(curr,par);
        dfs(curr.left,curr);
        dfs(curr.right,curr);
    }
}

//Another method : convert tree into graph and perform bfs
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(k == 0) {
            res.add(target.val);
            return res;
        }
        adj = new ArrayList<>();
        for(int i=0;i<=500;i++)
            adj.add(new ArrayList<>());
        
        convertToGraph(root);
        
        Queue<int[]> aux = new LinkedList<>();
        boolean[] visited = new boolean[501];
        
        aux.add(new int[]{target.val,0});
        visited[target.val] = true;
        
    
        while(!aux.isEmpty()) {
            int[] p = aux.poll();
            int curr = p[0], d = p[1];
            if(d == k)
                res.add(curr);
            else {
                for(int ele : adj.get(curr))
                    if(!visited[ele]){
                        aux.add(new int[]{ele,d+1});
                        visited[ele] = true;
                    }
            }
        }
        return res;
    }
    private void convertToGraph(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
            convertToGraph(root.left);
        }
        if(root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
            convertToGraph(root.right);
        }
    }
}
