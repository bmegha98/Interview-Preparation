/*
Given an array arr[] of length n. Find all possible unique permutations of the array.


Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
4 5
5 4

Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input
and returns a sorted list of lists containing all unique permutations of the array.
*/
//Time to generate one permutation = O(n), total time = O(n*n!)
class Solution {
    static ArrayList<ArrayList<Integer>> res;
    static Set<ArrayList<Integer>> aux;
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , 
            int n) {
        // code here
        res = new ArrayList<>();
        aux = new HashSet<>();
        Collections.sort(arr);
        helper(arr,0,n);
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
    
    private static void helper(ArrayList<Integer> A, int ind, int n) {
        if(ind == n-1) {
            ArrayList<Integer> tmp = new ArrayList<>(A);
            if(!aux.contains(tmp)) {
                aux.add(tmp);
                res.add(tmp);
            }
            return;
        }   
        
        for(int i=ind;i<n;i++) {
            if(i>ind && A.get(i) == A.get(i-1))
                continue;
            swap(A,i,ind);
            helper(A,ind+1,n);
            swap(A,i,ind);
        }
    }
    
    private static void swap(ArrayList<Integer> A, int i, int j) {
        int tmp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,tmp);
    }
}
