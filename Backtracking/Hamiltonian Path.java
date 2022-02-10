/*
A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once. Given an undirected graph  the task is to check if a 
Hamiltonian path is present in it or not.


Example 1:

Input:
N = 4, M = 4
Edges[][]= { {1,2}, {2,3}, {3,4}, {2,4} }
Output:
1 
Explanation: 
There is a hamiltonian path: 
1 -> 2 -> 3 -> 4 
Example 2:

Input:
N = 4, M = 3 
Edges[][] = { {1,2}, {2,3}, {2,4} } 
Output: 
0 
Explanation: 
It can be proved that there is no 
hamiltonian path in the given graph
 

Your task:
You don't need to read input or print anything. Your task is to complete the function check() which takes the N( the number of vertices), M (Number of edges) 
and the list of Edges[][] (where Edges[i] denotes the undirected Edge between vertices Edge[i][0] and Edges[i][1] ) as input parameter and returns true (boolean
value) if the graph contains Hamiltonean path,otherwise returns false. 


Expected Time Complexity: O(N!).
Expected Auxiliary Space: O(N+M).


Constraints:
1 ≤ N ≤ 10
1 ≤ M ≤ 15
Size of Edges[i] is 2
1 ≤ Edges[i][0],Edges[i][1] ≤ N
*/

class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges){ 
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=N;i++)
            adj.add(new ArrayList<>());
            
        for(ArrayList<Integer> e : Edges) {
            int u = e.get(0), v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[N+1];
        for(int i=1;i<=N;i++)
            if(!visited[i] && helper(adj,visited,i,N,1))
                return true;
        return false;
    }
    
    private boolean helper(List<List<Integer>> A,boolean[] V, int curr, int n,
            int count) {
        if(count == n)
            return true;
        V[curr] = true;
        for(int u : A.get(curr)) 
            if(!V[u] && helper(A,V,u,n,count+1))
                return true;
        V[curr] = false;
        return false;
    }
}
