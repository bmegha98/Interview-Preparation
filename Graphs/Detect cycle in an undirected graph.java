//Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 


class Solution
{
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++) {
            if(!visited[i] && cycleHelper(adj, visited, i , -1))
                return true;
        }
        return false;
    }
    private boolean cycleHelper(ArrayList<ArrayList<Integer>> A, boolean[] V, int start, int parent) {
        V[start] = true;
        for(int ele : A.get(start)) {
            if(!V[ele]) {
                if(cycleHelper(A,V,ele,start)) 
                    return true;
            }
            else if(ele != parent || ele == start)
                return true;
        }
        return false;
    }
}
