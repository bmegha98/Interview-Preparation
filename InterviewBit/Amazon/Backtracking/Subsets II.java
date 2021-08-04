/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
*/

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    Set<ArrayList<Integer>> aux;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        res = new ArrayList<>();
        int n = A.size();
        res.add(new ArrayList<>());
        if(n == 0)
            return res;
        Collections.sort(A);
        aux = new HashSet<>();
        subsetHelper(A,0,new ArrayList<>());
        
        return res;
        
    }
    private void subsetHelper(ArrayList<Integer> A, int start, ArrayList<Integer> tmp) {
        if(start == A.size())
            return;
        for(int i=start;i<A.size();i++) {
            tmp.add(A.get(i));
            if(!aux.contains(tmp)) {
                ArrayList<Integer> l = new ArrayList<>(tmp);
                aux.add(l);
                res.add(l);
            }
            subsetHelper(A,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
