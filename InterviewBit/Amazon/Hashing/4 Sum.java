/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the 
sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = A.size();
        if(n < 4)
            return res;
        Map<Integer,ArrayList<int[]>> aux = new HashMap<>();
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) {
                ArrayList<int[]> l;
                int s = A.get(i)+A.get(j);
                if(aux.containsKey(s))
                    l = aux.get(s);
                else
                    l = new ArrayList<>();
                l.add(new int[]{i,j});
                aux.put(s,l);
            }
        Set<ArrayList<Integer>> s = new HashSet<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) {
                int rem = B-(A.get(i)+A.get(j));
                if(aux.containsKey(rem)) {
                    for(int[] p : aux.get(rem)) 
                        if(i != p[0] && i != p[1] && j != p[0] && j != p[1]){
                            tmp.add(A.get(i));
                            tmp.add(A.get(j));
                            tmp.add(A.get(p[0]));
                            tmp.add(A.get(p[1]));
                            Collections.sort(tmp);
                            s.add(new ArrayList<>(tmp));
                            tmp.clear();
                        }
                }
            }
        
        for(ArrayList<Integer> l : s)
            res.add(l);
        Collections.sort(res,(a,b)->{
            if(a.get(0) != b.get(0))
                return a.get(0)-b.get(0);
            if(a.get(1) != b.get(1))
                return a.get(1)-b.get(1);
            if(a.get(2) != b.get(2))
                return a.get(2)-b.get(2);
            if(a.get(3) != b.get(3))
                return a.get(3)-b.get(3);
            return 0;
        });
        return res;
    }
}
