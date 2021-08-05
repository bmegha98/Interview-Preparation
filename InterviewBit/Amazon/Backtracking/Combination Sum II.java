/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    Set<ArrayList<Integer>> aux;
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        res = new ArrayList<>();
        int n = A.size();
        Collections.sort(A);
        aux = new HashSet<>();
        sumHelper(A,B,0,new ArrayList<>());
        return res;
    }
    private void sumHelper(ArrayList<Integer> A, int sum,int start, ArrayList<Integer> tmp) {
        if(sum == 0) {
            if(!aux.contains(tmp)) {
                ArrayList<Integer> l = new ArrayList<>(tmp);
                aux.add(l);
                res.add(l);
            }
            return;
        }
        for(int i=start;i<A.size();i++)
            if(A.get(i) <= sum){
                tmp.add(A.get(i));
                sumHelper(A,sum-A.get(i),i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
            else
                return;
    }
}
