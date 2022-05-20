/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the 
n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/
// Time = O(V + VlogV + ElogV) , Space = O(V+E) , sum(deg(ui)) = 2*E
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        
        Queue<int[]> aux = new PriorityQueue<>(1, (a,b)->a[1]-b[1]);
        aux.add(new int[]{k,0});
        
        Set<Integer> res = new HashSet<>();
        dist[k] = 0;
        
        int minTime = Integer.MIN_VALUE;
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            int u = curr[0], d = curr[1];
            if(!res.contains(u)) {
                res.add(u);
                if(d == Integer.MAX_VALUE)
                    return -1;
                minTime = Math.max(minTime,d);
            }
            else
                continue;
            for(int[] ele : adj.get(u)) {
                int v = ele[0], w = ele[1];
                if(!res.contains(v) && dist[v] > d+w) {
                    dist[v] = d+w;
                    aux.add(new int[]{v,dist[v]});
                }
            }
        }
        
        for(int i=1;i<=n;i++)
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
        return minTime;
    }
}
