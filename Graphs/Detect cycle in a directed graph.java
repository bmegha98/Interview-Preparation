//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

//Check if there is any back edge to explored node : 0-> unvisited, 1-> explored, 2-> processed

class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] color = new int[V];
        for(int i =0;i<V;i++) {
            if(color[i] == 0 && cycleHelper(adj,color,i))
                return true;
        }
        return false;
    }
    
    private boolean cycleHelper(ArrayList<ArrayList<Integer>> A, int[] color, int start) {
        color[start] = 1;
        for(int ele : A.get(start)) {
            if(color[ele] == 0) {
                if(cycleHelper(A,color,ele))
                    return true;
            }
            else if(color[ele] == 1)
                return true;
        }
        color[start] = 2;
        return false;
    }
}
