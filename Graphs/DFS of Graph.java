//Given a connected undirected graph. Perform a Depth First Traversal of the graph.

class Solution
{
    ArrayList<Integer> res;
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        res = new ArrayList<>();
        if(V == 1)
        {
            res.add(0);
            return res;
        }
        boolean[] visited = new boolean[V];
        //dfsRec(adj, visited, 0);
        dfsIterative(adj, visited, 0)
        return res;
    }
    private void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] V, int start) {
        res.add(start);
        V[start] = true;
        for(int ele : adj.get(start))
            if(!V[ele])
                dfsRec(adj,V,ele);
    }
    private void dfsIterative(ArrayList<ArrayList<Integer>> adj, boolean[] V, int start) {
        Stack<Integer> aux = new Stack<>();
        aux.push(start);
        V[start] = true;
        
        while(!aux.isEmpty()) {
            int curr = aux.pop();
            res.add(curr);
            for(int ele : adj.get(curr))
                if(!V[ele]) {
                    aux.push(ele);
                    V[ele] = true;
                }
        }
    }
}
