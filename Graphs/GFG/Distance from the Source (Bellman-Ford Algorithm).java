/*
Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
*/

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        final int MAX = 100000000;
        int[] distance = new int[V];
        Arrays.fill(distance,MAX);
        distance[S] = 0;
        
        for(int i=1;i<V;i++) {
            boolean isUpdated = false;
            for(ArrayList<Integer> edge : adj) {
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(distance[u] != MAX && distance[u]+w < distance[v]) {
                    distance[v] = distance[u]+w;
                    isUpdated = true;
                }
            }
            if(!isUpdated)
                break;
        }
        for(ArrayList<Integer> edge : adj) {
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(distance[u] != MAX && distance[u]+w < distance[v]) {
                    System.out.println("Negative edge weight cycle exists !");
                    return new int[V];
                }
        }
        return distance;
    }
}
