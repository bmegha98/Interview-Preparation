/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to
target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is 
different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/

class Solution {
    Set<List<Integer>> aux;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        aux = new HashSet<>();
        helper(candidates,target,new ArrayList<>());
        for(List<Integer> l : aux)
            res.add(l);
        return res;
    }
    private void helper(int[] A, int target,List<Integer> l) {
         //System.out.println(l);
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>(l);
            Collections.sort(tmp);
            aux.add(tmp);
            return;
        }
        for(int ele : A) {
            if(ele <= target) {
                l.add(ele);
                helper(A,target-ele,l);
                l.remove(l.size()-1);       //Backtrack
            }
        }
    }
}

//

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if(A[i] <= target) {
                l.add(A[i]);
                helper(A,target-A[i],i,l);
                l.remove(l.size()-1);       //Backtrack
            }
        }
       
    }
}
