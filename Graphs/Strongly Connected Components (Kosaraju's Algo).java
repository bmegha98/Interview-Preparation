/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
*/

class Solution
{
    //Function to find number of strongly connected components in the graph.
    Stack<Integer> aux = new Stack<>();
    ArrayList<ArrayList<Integer>> rev;
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        if(V == 1)
            return 1;
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0;i<V;i++)
            if(!visited[i])
                dfs(adj,visited,i);
        rev = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            rev.add(new ArrayList<>());
        transposeGraph(adj,V);
        Arrays.fill(visited,false);
        while(!aux.isEmpty()) {
            int start = aux.pop();
            if(!visited[start]) {
                count++;
                dfs2(visited,start);
            }
        }
        return count;
    }
    private void dfs(ArrayList<ArrayList<Integer>> A, boolean[] V, int start) {
        V[start] = true;
        for(int ele : A.get(start))
            if(!V[ele])
                dfs(A,V,ele);
        aux.push(start);
    }
    private void transposeGraph(ArrayList<ArrayList<Integer>> A,int V) {
        for(int i =0;i<V;i++) {
            for(int ele : A.get(i)) {
                rev.get(ele).add(i);
            }
        }
    }
    private void dfs2(boolean[] V,int start) {
        V[start] = true;
        for(int ele : rev.get(start))
            if(!V[ele])
                dfs2(V,ele);
    }
}
