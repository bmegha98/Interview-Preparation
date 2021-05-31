/*
There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is 
expressed as a pair: [0, 1]
Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
Example 1:

Input: 
N = 4, P = 3
prerequisites = {{1,0},{2,1},{3,2}}
Output:
Yes
Explanation:
To do task 1 you should have completed
task 0, and to do task 2 you should 
have finished task 1, and to do task 3 you should have finished task 2. So it is possible.
*/
//Check if topological ordering is possible or not i.e. check if cycle exists or not

class Solution {
    Stack<Integer> aux = new Stack<>();
    public boolean isPossible(int N, int[][] prerequisites)
    {
        if(N == 1)
            return true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        
        for(int[] e : prerequisites) 
            adj.get(e[1]).add(e[0]);
           
        
        for(int i=0;i<N;i++) {
            if(!visited[i])
                dfs(adj,visited,i);
        }
        
        int ind = 0;
        int[] labelling = new int[N];
        while(!aux.isEmpty()) {
            int curr = aux.pop();
            labelling[curr] = ind;
            ind++;
        }
            
        for(int[] e : prerequisites)
            if(labelling[e[1]] >= labelling[e[0]])
                return false;
        
        return true;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> A, boolean[] V, int start) {
        V[start] = true;
        for(int ele : A.get(start))
            if(!V[ele])
                dfs(A,V,ele);
        aux.push(start);
    }
    
}

//Just check if its a DAG or not
class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        if(N == 1)
            return true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] color = new int[N];
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        
        for(int[] e : prerequisites) 
            adj.get(e[1]).add(e[0]);
           
        
        for(int i=0;i<N;i++) {
            if(color[i] == 0 && isCyclic(adj,color,i))
                return false;
        }
        
        return true;
    }
    
    private boolean isCyclic(ArrayList<ArrayList<Integer>> A, int[] color, int start) {
        color[start] = 1;
        for(int ele : A.get(start)) {
            if(color[ele] == 0 && isCyclic(A,color,ele))
                return true;
            else if(color[ele] == 1)
                return true;
        }
        color[start] = 2;
        return false;
    }
    
}
