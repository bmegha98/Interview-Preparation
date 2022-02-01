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
You don't have to read input or print anything. Your task is to complete the function subsets() which takes the array of integers as input and returns the list
of list containing the subsets of the given set of numbers in lexicographical order.
 
Expected Time Complexity : O(2^n)))
Expected Auxiliary Space : O(2^n*length of each subset)
 
Constraints :
1 <= n <= 20
1 <= arr[i] <=10
*/

class Solution
{
    private static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        //code here
        res = new ArrayList<>();
        if(A.size()==0)
            return res;
        helper(A,0,new ArrayList<>());
        Collections.sort(res,(p,q)->{
                int i = 0;
                while(i < Math.min(p.size(), q.size())){
                    if(p.get(i) == q.get(i)){
                        i++;
                        continue;
                    }
                    if(p.get(i) < q.get(i)){
                        return -1;
                    }
                    return 1;
                }
                if(i < q.size()) return -1;
                if(i < p.size()) return 1;
                return 0;
        });
        return res;
    }
    
    private static void helper(ArrayList<Integer> A, int ind, ArrayList<Integer> tmp) {
        if(ind == A.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        helper(A,ind+1,tmp);  //exclude
        tmp.add(A.get(ind));
        helper(A,ind+1,tmp);  //include
        tmp.remove(tmp.size()-1);
    }
}
