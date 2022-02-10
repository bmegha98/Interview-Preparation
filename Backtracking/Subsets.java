/*
Given a set of positive integers, find all its subsets.

Example 1 :

Input : 
array = {1, 2, 3}
Output :
// this space denotes null element. 
1
1 2
1 2 3
1 3
2
2 3
3
Explanation: 
The following are the subsets 
of the array {1, 2, 3}.
Example 2 :

Input :
array = {1, 2}
Output :

1 
1 2
2
Explanation :
The following are the 
subsets of {1, 2}.
Your task :
You don't have to read input or print anything. Your task is to complete the function subsets() which takes the array of integers as input and returns the list of
list containing the subsets of the given set of numbers in lexicographical order.
*/

class Solution
{
    private static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        //code here
        res = new ArrayList<>();
        if(A.size()==0)
            return res;
        helper(A,0,A.size(),new ArrayList<>());
        
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
            if(i < a.size())
                return 1;
            if(j < b.size())
                return -1;
            return 0;
        });
        return res;
    }
    
    private static void helper(ArrayList<Integer> A, int ind, int n, 
                                ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for(int i=ind;i<n;i++) {
            tmp.add(A.get(i));
            helper(A,i+1,n,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
