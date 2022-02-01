/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

//Using Set
class Solution {
    List<List<Integer>> res;
    Set<List<Integer>> aux;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        aux = new HashSet<>();
        int n = nums.length;
        if(n == 0)
            return res;
        helper(nums, 0, n, new ArrayList<>());
        return res;
    }
    private void helper(int[] A, int ind, int n, List<Integer> tmp) {
        if(ind == n) {
            List<Integer> l = new ArrayList<>(tmp);
            Collections.sort(l);
            if(!aux.contains(l)) {
                res.add(l);
                aux.add(l);
            }
            return;
        }
        
        tmp.add(A[ind]);
        helper(A,ind+1,n,tmp);
        tmp.remove(tmp.size()-1);
        helper(A,ind+1,n,tmp);
    }
}

//Without using Set
