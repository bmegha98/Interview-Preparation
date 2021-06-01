/*
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
*/

//Prim's algorithm Time = O(VlogV + ElogV) = O(ElogV) , Space = O(V)

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean[] inMST = new boolean[V];
        Queue<int[]> aux = new PriorityQueue<>(1,(a,b)->a[1]-b[1]);
        
        int[] cost = new int[V];
        Arrays.fill(cost,Integer.MAX_VALUE);
        
        aux.add(new int[]{0,0});
        cost[0] = 0;
        int count = 0,ans = 0;
        
        while(count != V) {
            int[] curr = aux.poll();
            int u = curr[0];
            if(!inMST[u]) {
                for(ArrayList<Integer> p : adj.get(u)){
                    int v = p.get(0), c = p.get(1);
                    if(!inMST[v] && cost[v] > c) {
                        cost[v] = c;
                        aux.add(new int[]{v,cost[v]});
                    }
                }
                inMST[u] = true;
                count++;
            }
        }
        
        for(int c : cost)
            ans += c;
        return ans;
    }
}

//Kruskal's algorithm
class UnionFind{
    int[] parent,rank;
    int n;
    public UnionFind(int V) {
        n = V;
        parent = new int[n];
        rank = new int[n];
        MAKESET();
    }
    private void MAKESET() {
        for(int i=0;i<n;i++)
            parent[i] = i;
    }
    public int FIND(int ele) {
        if(parent[ele] == ele)
            return ele;
        return parent[ele] = FIND(parent[ele]);     //path compression
    }
    public void UNION(int rootA,int rootB) {
        if(rank[rootA] < rank[rootB])               //union by rank
            parent[rootA] = rootB;
        else if(rank[rootA] > rank[rootB])
            parent[rootB] = rootA;
        else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i=0;i<V;i++) {
            for(ArrayList<Integer> p : adj.get(i))
                edges.add(new int[]{i,p.get(0),p.get(1)});
        }
        
        Collections.sort(edges, (a,b)->a[2]-b[2]);
        UnionFind f = new UnionFind(V);
        int ans = 0;
        for(int[] e : edges) {
            int rootU = f.FIND(e[0]);
            int rootV = f.FIND(e[1]);
            if(rootU != rootV) {
                ans += e[2];
                f.UNION(rootU,rootV);
            }
        }
        return ans;
    }
}
