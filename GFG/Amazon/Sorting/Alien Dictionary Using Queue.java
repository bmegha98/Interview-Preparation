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
Here order of characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is 'c', 'a', 'b' Note that words are sorted and in the given language "caa" comes before "aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
*/

class Solution
{
    public String findOrder(String [] dict, int n, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[K];
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
                inDegree[second.charAt(q)-'a']++;
                break;
            }
        }
        
        Queue<Integer> aux = new LinkedList<>();
        for(int i=0;i<K;i++)
            if(inDegree[i] == 0)
                aux.add(i);
        
        String res = "";
        while(!aux.isEmpty()) {
            char ch = (char)(aux.poll()+'a');
            res += ch;
            for(int ele : adj.get(ch-'a')) {
                inDegree[ele]--;
                if(inDegree[ele] == 0)
                    aux.add(ele);
            }
        }
        return res;
    }
}
