/*
Given a graph with V vertices. Find the number of Provinces.
Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numProvinces() which takes an integer V and an adjacency matrix adj as input 
and returns the number of provinces. adj[i][j] = 1, if nodes i and j are connected and adj[i][j] = 0, if not connected.
*/
//Time = O(V^2) , Space = O(V)
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0;i<V;i++)
            if(!visited[i]){
                count++;
                dfs(adj,visited,i);
            }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> A, boolean[] V, int start) {
        V[start] = true;
        for(int i =0;i<A.size();i++){
            int ele = A.get(start).get(i);
            if(ele == 1 && !V[i])
                dfs(A,V,i);
        }
    }
}
