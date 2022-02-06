/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
*/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(1,k,n,new ArrayList<>());
        return res;
    }
    private void helper(int ind, int k, int n, List<Integer> tmp) {
        if(k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i=ind;i<=n;i++){
            tmp.add(i);
            helper(i+1,k-1,n,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}

//or

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(1,k,n,new ArrayList<>());
        return res;
    }
    private void helper(int ind, int k, int n, List<Integer> tmp) {
        if(k == 0 || ind > n) {
            if(k == 0)
                res.add(new ArrayList<>(tmp));
            return;
        }
        
        tmp.add(ind);
        helper(ind+1,k-1,n,tmp);
        tmp.remove(tmp.size()-1);
        
        helper(ind+1,k,n,tmp);
    }
}
