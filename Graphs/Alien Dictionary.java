/*
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the 
function is correct else 0 denoting incorrect string returned.
Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
*/

//Using Queue

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for(int i=0;i<K;i++)
            adj.add(new ArrayList<>());
        int[] indegree = new int[K];
        for(int i = 0;i<N-1;i++)
        {
            String s = dict[i], t = dict[i+1];
            int j = 0;
            while(j < s.length() && j < t.length()) {
                char x = s.charAt(j), y = t.charAt(j);
                if(x == y) {
                    j++;
                    continue;
                }
                adj.get(x-'a').add(y);
                indegree[y-'a']++;
                break;
            }
        }
        Queue<Character> aux = new LinkedList<>();
        for(int i=0;i<K;i++)
            if(indegree[i] == 0)
                aux.add((char)(i+'a'));
        
        String res = "";
        while(!aux.isEmpty()) {
            char ch = aux.poll();
            res += ch;
            for(char tmp : adj.get(ch-'a')) {
                indegree[tmp-'a']--;
                if(indegree[tmp-'a'] == 0)
                    aux.add(tmp);
            }
        }
        return res;
    }
}

//Using DFS
class Solution
{
    Stack<Character> aux = new Stack<>();
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for(int i=0;i<K;i++)
            adj.add(new ArrayList<>());
        boolean[] visited = new boolean[K];
        for(int i = 0;i<N-1;i++)
        {
            String s = dict[i], t = dict[i+1];
            int j = 0;
            while(j < s.length() && j < t.length()) {
                char x = s.charAt(j), y = t.charAt(j);
                if(x == y) {
                    j++;
                    continue;
                }
                adj.get(x-'a').add(y);
                break;
            }
        }
        
        for(int i=0;i<K;i++)
            if(!visited[i])
                dfs(adj,visited,(char)(i+'a'));
        
        String res = "";
        while(!aux.isEmpty()) 
            res += aux.pop();
        return res;
    }
    
    private void dfs(ArrayList<ArrayList<Character>> A, boolean[] V, char s) {
        V[s-'a'] = true;
        for(char tmp : A.get(s-'a'))
            if(!V[tmp-'a'])
                dfs(A,V,tmp);
        aux.push(s);
    }
}
