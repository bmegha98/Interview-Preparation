/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int nums[] = new int[9];
        for(int i = 0;i<9;i++)
            nums[i] = i+1;
        
        helper(nums,n,k,0,new ArrayList<>());
        return res;
    }
    private void helper(int[] A,int target,int k,int start,List<Integer> l) {
        if(k == 0) 
        {
            if(target == 0) 
                res.add(new ArrayList<>(l));
            return;
        }
        for(int i = start;i<A.length;i++) {
            if(A[i] <= target) {
                l.add(A[i]);
                helper(A,target-A[i],k-1,i+1,l);
                l.remove(l.size()-1);
            }
        }
    }
}
