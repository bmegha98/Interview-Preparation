/*
Given 2 sorted arrays Ar1 and Ar2 of size N each. Merge the given arrays and find the sum of the two middle elements of the merged array.

Example 1:

Input:
N = 5
Ar1[] = {1, 2, 4, 6, 10}
Ar2[] = {4, 5, 6, 9, 12}
Output: 11
Explanation: The merged array looks like
{1,2,4,4,5,6,6,9,10,12}. Sum of middle
elements is 11 (5 + 6).
 

Example 2:

Input:
N = 5
Ar1[] = {1, 12, 15, 26, 38}
Ar2[] = {2, 13, 17, 30, 45}
Output: 32
Explanation: The merged array looks like
{1, 2, 12, 13, 15, 17, 26, 30, 38, 45} 
sum of middle elements is 32 (15 + 17).
*/
class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        if(n == 1)
            return ar1[0]+ar2[0];
        
        return helper(ar1,0,n-1,ar2,0,n-1);
    }
    
    int helper(int[] A, int lowA, int highA, int[] B, int lowB, int highB) {
        if(lowA == highA)
            return A[lowA]+B[lowB];
        if(highA-lowA == 1) {
            return Math.max(A[lowA], B[lowB]) + Math.min(A[highA], B[highB]);
        }
        
        int m1 = getMiddleSum(A, lowA, highA);
        int m2 = getMiddleSum(B, lowB, highB);
        //System.out.println(m1 +": "+m2);
        if(m1 == m2)
            return m1;
        
        int n = highA-lowA+1;
        if(m1 < m2) {
            if(n%2 == 0)
                return helper(A,(lowA+highA)/2,highA,B,lowB,(lowB+highB+1)/2);
            return helper(A,(lowA+highA)/2,highA,B,lowB,(lowB+highB)/2);
        }
        else {
            if(n%2 == 0)
                return helper(A,lowA,(lowA+highA+1)/2,B,(lowB+highB)/2,highB);
            return helper(A,lowA,(lowA+highA)/2,B,(lowB+highB)/2,highB);
        }
            
    }
    int getMiddleSum(int[] A,int l,int h) {
        int n = h-l+1;
        if(n%2 == 1)
            return 2*A[l+ n/2];
        return A[l+ n/2]+A[l + (n/2 - 1)];
    }
}
