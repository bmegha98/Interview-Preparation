/*
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
*/

//Time = O((V+E)logV) , Space = O(V)
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Prim's algorithm
        int[] cost = new int[V];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[0] = 0;
        
        boolean[] inMST = new boolean[V];
        int count = 0;
        Queue<int[]> aux = new PriorityQueue<>(1, (a,b)->a[1]-b[1]);
        
        aux.add(new int[]{0,0});
        while(count != V) {
            int[] tmp = aux.poll();
            int u = tmp[0];
            if(!inMST[u]) {
                for(ArrayList<Integer> edge : adj.get(u)) {
                    int v = edge.get(0),w = edge.get(1);
                    if(!inMST[v] && cost[v] > w) {
                        cost[v] = w;
                        aux.add(new int[]{v,cost[v]});
                    }
                }
                inMST[u] = true;
                count++;
            }
        }
        int totalCost = 0;
        for(int c : cost)
            totalCost += c;
        return totalCost;
    }
}
