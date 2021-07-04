class Solution
{
    Stack<Integer> aux = new Stack<>();
    public String findOrder(String [] dict, int n, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[K];
        
        for(int i=0;i<K;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n-1;i++) {
            String first = dict[i], second = dict[i+1];
            int size1 = first.length(), size2 = second.length();
            int p=0,q=0;
            while(p<size1 && q<size2) {
                if(first.charAt(p) == second.charAt(q)) {
                    p++;
                    q++;
                    continue;
                }
                adj.get(first.charAt(p)-'a').add(second.charAt(q)-'a');
                break;
            }
        }
        
        for(int i=0;i<K;i++) {
            if(!visited[i])
                dfs(adj,visited,i);
        }
        
        String res = "";
        while(!aux.isEmpty()) {
            char ch = (char)(aux.pop()+'a');
            res += ch;
        }
        return res;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> A, boolean[] V, int start) {
        V[start] = true;
        for(int ele : A.get(start))
            if(!V[ele])
                dfs(A,V,ele);
        aux.push(start);
    }
}
