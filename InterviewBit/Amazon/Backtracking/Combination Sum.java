/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
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
                sumHelper(A,sum-A.get(i),i,tmp);
                tmp.remove(tmp.size()-1);
            }
            else
                return;
    }
}
