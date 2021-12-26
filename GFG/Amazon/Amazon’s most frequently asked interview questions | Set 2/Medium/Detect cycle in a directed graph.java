//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] color = new int[V];
        for(int i=0;i<V;i++)
            if(color[i] == 0) {
                if(cycleHelper(adj,color,i))
                    return true;
            }
        return false;
    }
    
    private boolean cycleHelper(ArrayList<ArrayList<Integer>> A, int[] color,
        int start) {
            color[start] = 1;
            for(int v:A.get(start)) {
                if(color[v] == 0) {
                    if(cycleHelper(A,color,v))
                        return true;
                }
                else if(color[v] == 1)
                    return true;
            }
            color[start] = 2;
            return false;
        }
}
