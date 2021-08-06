/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
Make sure the combinations are sorted.

To elaborate,
Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
*/

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        res = new ArrayList<>();
        helper(A,B,1,new ArrayList<>());
        return res;
        
    }
    private void helper(int n, int k,int start, ArrayList<Integer> tmp) {
        if(start > n || k == 0) {
            if(k == 0) {
                ArrayList<Integer> l = new ArrayList<>(tmp);
                res.add(l);
            }
            return;
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            helper(n,k-1,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
