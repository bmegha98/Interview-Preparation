/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
Input Format
First and only argument is an integer array A.
Output Format
Return an integer denoting the maximum value of j - i;
Example Input
Input 1:

 A = [3, 5, 4, 2]
Example Output
Output 1:

 2
Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        int n = A.length,res = 0;
        int[] leftMin = new int[n];
        leftMin[0] = A[0];
        for(int i=1;i<n;i++)
            leftMin[i] = Math.min(leftMin[i-1],A[i]);
        int[] rightMax = new int[n];
        rightMax[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--)
            rightMax[i] = Math.max(rightMax[i+1], A[i]);
        
        int i=0,j=0;
        while(i<n && j<n) {
            if(leftMin[i] <= rightMax[j]) {
                res = Math.max(res,j-i);
                j++;
            }
            else
                i++;
        }
        return res;
    }
}
