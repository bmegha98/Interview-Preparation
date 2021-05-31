/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
*/

class Solution
{
    Stack<Integer> aux = new Stack<>();
    ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        if(V == 1)
            return 1;
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(adj,visited,i);
        
        for(int i =0;i<V;i++)
            revAdj.add(new ArrayList<>());
        transposeGraph(V,adj);
        Arrays.fill(visited,false);
        
        int count = 0;
        while(!aux.isEmpty()) {
            int start = aux.pop();
            if(!visited[start]) {
                count++;
                dfsRev(visited,start);
            }
        }
        return count;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> A, boolean[] V, int start) {
        V[start] = true;
        for(int ele : A.get(start))
            if(!V[ele])
                dfs(A,V,ele);
        aux.push(start);
    }
    
    private void transposeGraph(int V, ArrayList<ArrayList<Integer>> A) {
        for(int i = 0;i<V;i++)
            for(int ele : A.get(i))
                revAdj.get(ele).add(i);
    }
    
    private void dfsRev(boolean[] V, int start) {
        V[start] = true;
        for(int ele : revAdj.get(start))
            if(!V[ele])
                dfsRev(V,ele);
    }
}
