/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
*/

//Using Bit Masking T(n) = O(n*2^n + nlogn)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = A.size();
        if(n == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        Set<ArrayList<Integer>> aux = new HashSet<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Collections.sort(A);
        for(int i=0;i<Math.pow(2,n);i++) {
            int num = i,count = 0;
            while(num > 0) {
                if((num&1) == 1)
                    tmp.add(A.get(count));
                count++;
                num >>= 1;
            }
            
            aux.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        
        for(ArrayList<Integer> l : aux)
            res.add(l);
        Collections.sort(res, (a,b)->{
            int i = 0, j = 0;
            while(i<a.size() && j<b.size()) {
                if(a.get(i) < b.get(j))
                    return -1;
                if(a.get(i) > b.get(j))
                    return 1;
                i++;
                j++;
            }
            
            if(i == a.size())
                return -1;
            return 1;
        });
        
        return res;
    }
}

//Recursive
public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        res = new ArrayList<>();
        int n = A.size();
        res.add(new ArrayList<>());
        if(n == 0)
            return res;
        Collections.sort(A);
        subsetHelper(A,0,new ArrayList<>());
        
        return res;
    }
    
    private void subsetHelper(ArrayList<Integer> A, int start, ArrayList<Integer> tmp) {
        if(start == A.size())
            return;
        for(int i=start;i<A.size();i++) {
            tmp.add(A.get(i));
            res.add(new ArrayList<>(tmp));
            subsetHelper(A,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
