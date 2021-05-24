/*
Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle. A
string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
*/

//Time = O(n) , space = O(1)
class Solution
{
    static int isCircle(int N, String A[])
    {
        if(N == 1) {
            if(A[0].charAt(0) == A[0].charAt(A[0].length()-1))
                return 1;
            return 0;
        }
        
        ArrayList<ArrayList<Character>> adj = new ArrayList<>(26);
        boolean[] mark = new boolean[26];
        int[] in = new int[26];
        int[] out = new int[26];
        boolean[] visited = new boolean[26];
        
        for(int i=0;i<26;i++)
            adj.add(new ArrayList<Character>());
            
        for(String s : A) {
            char u = s.charAt(0),v = s.charAt(s.length()-1);
            mark[u-'a'] = true;
            mark[v-'a'] = true;
            out[u-'a']++;
            in[v-'a']++;
            adj.get(u-'a').add(v);
        }
        
        dfs(adj,visited,A[0].charAt(0));
        
        for(int i = 0;i<26;i++) {
            if(mark[i] && !visited[i])
                return 0;
            if(in[i] != out[i])
                return 0;
        }
        return 1;
                
    }
    
    private static void dfs(ArrayList<ArrayList<Character>> adj,boolean[] visited,
        char s) {
        visited[s-'a'] = true;
        for(char tmp : adj.get(s-'a')) {
           if(!visited[tmp-'a'])
            dfs(adj,visited,tmp);
        }
    }
}
