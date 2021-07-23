/*
Given an unsorted integer array, find the first missing positive integer.
Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
*/
//Consider only +ve values
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        
        for(int i=0;i<n;i++)
            if(A[i] < 1)
                A[i] = n+1;
        
        for(int i=0;i<n;i++) {
            if(Math.abs(A[i]) <= n && A[Math.abs(A[i])-1] > 0)
                A[Math.abs(A[i])-1] *= -1;
        }
        //for(int ele : A) System.out.println(ele);
        for(int i=0;i<n;i++)
            if(A[i] > 0) 
                return i+1;
            
        return n+1;
    }
}
