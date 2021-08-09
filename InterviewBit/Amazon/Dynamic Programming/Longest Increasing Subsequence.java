/*
Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as 
possible. This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.
Input Format:

The first and the only argument is an integer array A.
Output Format:

Return an integer representing the length of the longest increasing subsequence.
Constraints:

1 <= length(A) <= 2500
1 <= A[i] <= 2000
Example :

Input 1:
    A = [1, 2, 1, 5]

Output 1:
    3
    
Explanation 1:
    The sequence : [1, 2, 5]

Input 2:
    A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
    
Output 2:
    6

Explanation 2:
    The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
*/

//Recursion + Memoization
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int[] T;
    int ans = 1;
    public int lis(final int[] A) {
        int n = A.length;
        if(n < 2)
            return n;
        
        T = new int[n];
        Arrays.fill(T,-1);
        
        helper(A,n-1);
        return ans;
    }
    
    private int helper(int[] A, int end) {
        if(end == 0)
            return 1;
        if(T[end] != -1)
            return T[end];
        int res = 1;
        for(int i=0;i<end;i++){
            int tmp = -1;
            if(T[i] != -1)
                tmp = T[i];
            else {
                tmp = helper(A,i);
                T[i] = tmp;
            }
            if(A[i] < A[end] && tmp+1 > res)
                res = tmp+1;
        }
        ans = Math.max(ans,res);
        return T[end] = res;
    }
}

//Tabulation
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int n = A.length;
        if(n < 2)
            return n;
        
        int[] T = new int[n];
        T[0] = 1;
        int res = 1;
        for(int i=1;i<n;i++) {
            T[i] = 1;
            for(int j=0;j<i;j++)
                if(A[j] < A[i] && T[j]+1 > T[i])
                    T[i] = T[j]+1;
            
            res = Math.max(res,T[i]);
        }
        return res;
    }
}
