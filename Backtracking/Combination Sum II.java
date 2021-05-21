/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to 
target.Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
*/

class Solution {
    Set<List<Integer>> aux = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>());
        for(List<Integer> l : aux)
            res.add(l);
        return res;
    }
    
    private void helper(int[] A, int target,int start,List<Integer> l) {
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>(l);
            Collections.sort(tmp);
            aux.add(tmp);
            return;
        }
        for(int i = start;i<A.length;i++) {
            if(A[i] <= target) {
                l.add(A[i]);
                helper(A,target-A[i],i+1,l);
                l.remove(l.size()-1);
            }
        }
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return res;
    }
    
    private void helper(int[] A, int target,int start,List<Integer> l) {
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>(l);
            res.add(tmp);
            return;
        }
        for(int i = start;i<A.length;i++) {
            if(i > start && A[i] == A[i-1])
                continue;
            if(A[i] <= target) {
                l.add(A[i]);
                helper(A,target-A[i],i+1,l);
                l.remove(l.size()-1);
            }
        }
    }
}
