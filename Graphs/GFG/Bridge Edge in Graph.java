/*Given an undirected graph of V vertices and E edges and another edge (c-d), the task is to find if the given edge is a bridge in graph, i.e., removing the edge 
disconnects the graph.
*/

//if (c->d) is a bridge edge then number of connected components of the graph increases after removing the bridge edge.
//DFS is performed two times; with and without given edge to check if graph is still connected or not
class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        int numComponents = countComponents(V,adj);
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        
        if(numComponents == countComponents(V,adj))
            return 0;
        return 1;
            
    }
    private static int countComponents(int V,ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++)
            if(!visited[i]){
                count++;
                dfs(adj,visited,i);
            }
        return count;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> A,boolean[] V,int start) {
        V[start] = true;
        for(int ele : A.get(start))
            if(!V[ele])
                dfs(A,V,ele);
    }
}
