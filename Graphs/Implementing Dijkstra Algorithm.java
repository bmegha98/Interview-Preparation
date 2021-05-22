/*
Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
*/

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        Queue<int[]> aux = new PriorityQueue<>(1,(a,b)->a[1]-b[1]);
        aux.add(new int[]{S,0});
        
        boolean[] explored = new boolean[V];
        int count = 0;
        while(count != V) {
            int[] curr = aux.poll();
            if(!explored[curr[0]]) {
                for(ArrayList<Integer> p : adj.get(curr[0])) {
                    int u = curr[0],v=p.get(0),w=p.get(1);
                    if(curr[1] != Integer.MAX_VALUE && dist[v] > curr[1]+w) {
                        dist[v] = curr[1]+w;
                        aux.add(new int[]{v,dist[v]});
                    }
                }
                explored[curr[0]] = true;
                count++;
            }
        }
        return dist;
    }
}
