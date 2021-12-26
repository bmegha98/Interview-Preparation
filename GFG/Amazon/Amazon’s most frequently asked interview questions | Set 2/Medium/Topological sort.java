//Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

//Using queue
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] res = new int[V];
        int k = 0;
        int[] indegree = new int[V];
        for(int i=0;i<V;i++) 
            for(int v : adj.get(i))
                indegree[v]++;
        
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            if(indegree[i] == 0)
                q.add(i);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            res[k++] = curr;
            for(int v : adj.get(curr)) {
                indegree[v]--;
                if(indegree[v] == 0)
                    q.add(v);
            }
        }
        
        return res;
    }
}

//Using Stack
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static Stack<Integer> s;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] res = new int[V];
        int k = 0;
        s = new Stack<>();
        int[] visited = new int[V];
        
        for(int i=0;i<V;i++)
            if(visited[i] == 0)
                dfs(adj,visited,i);
        
        while(!s.isEmpty())
            res[k++] = s.pop();
        return res;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> A, int[] V, int start) {
        V[start] = 1;
        for(int v:A.get(start))
            if(V[v] == 0)
                dfs(A,V,v);
        
        s.push(start);
    }
}
