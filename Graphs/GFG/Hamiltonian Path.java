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
Expected Time Complexity: O(N!).
Expected Auxiliary Space: O(N+M).

Explanation: 
It can be proved that there is no hamiltonian path in the given graph
*/

class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=N;i++)
            adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> e : Edges) {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }
        
        boolean[] visited = new boolean[N+1];
        
        for(int i = 1;i<=N;i++) {
            if(hasPath(adj,visited,i,0))
                return true;
        }
        return false;
    }
    private boolean hasPath(ArrayList<ArrayList<Integer>> A, boolean[] V, int start, 
        int count) {
            V[start] = true;
            count++;
            if(count == V.length-1) 
                return true;
            
            for(int ele : A.get(start)) {
                if(!V[ele] && hasPath(A,V,ele,count)) 
                        return true;
            }
            V[start] = false;
            return false;
        }
}
