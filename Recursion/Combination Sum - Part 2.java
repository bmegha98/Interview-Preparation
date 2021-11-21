/*
Given an array of integers A[] of size N and a sum B, find all unique combinations in A where the sum is equal to B. Each number in A may only be used once in the
combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.


Example 1:

Input: 
N = 7
A = {9, 1, 2, 7, 6, 1, 5}
B = 8
Output: (1 1 6)(1 2 5)(1 7)(2 6)
Explaination: These are the only possible 
combinations for getting sum 8.

Example 2:

Input:
N = 5
A = {8, 1, 8, 6, 8}
B = 12
Output: Empty
Explainatioin: We cannot obtain sum 12 
from the given elements.
*/

class Solution
{
    static List<List<Integer>> res;
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
        // code here
        res = new ArrayList<>();
        if(N == 0)
            return res;
        Arrays.sort(A);
        helper(A,0,N,B,new ArrayList<>());
        return res;
    }
    
    static void helper(int[] A,int start,int n,int sum,List<Integer> tmp) {
        if(sum == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<n;i++) {
            if(i > start && A[i] == A[i-1])
                continue;
            if(A[i] > sum)
                break;
            tmp.add(A[i]);
            helper(A,i+1,n,sum-A[i],tmp);
            tmp.remove(tmp.size()-1);
        }
        
    }
}
