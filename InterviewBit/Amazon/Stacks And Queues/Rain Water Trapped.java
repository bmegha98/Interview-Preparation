/*
Problem Description
Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after
raining.
Problem Constraints
1 <= |A| <= 100000
Input Format
The only argument given is integer array A.
Output Format
Return the total water it is able to trap after raining.
Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:
 A = [1, 2]
Example Output
Output 1:
 6
Output 2:
 0
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        if(n < 3)
            return 0;
        
        int water = 0;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int left = 0, right = n-1;
        while(left <= right) {
            if(A[left] <= A[right]) {
                if(leftMax < A[left])
                    leftMax = A[left];
                else
                    water += leftMax-A[left];
                left++;
            }
            else {
                if(rightMax < A[right])
                    rightMax = A[right];
                else
                    water += rightMax-A[right];
                right--;
            }
        }
        return water;
    }
}
