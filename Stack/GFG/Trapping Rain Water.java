/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are 
being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = height[0];
        right[n-1] = height[n-1];
        
        for(int i=1;i<n;i++)
            left[i] = Math.max(left[i-1], height[i]);
        
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(right[i+1],height[i]);
        
        int water = 0;
        
        for(int i=1;i<n-1;i++)
            water += Math.min(left[i],right[i])-height[i];
        
        return water;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int left = 0, right = n-1;
        int water = 0;
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(leftMax <= height[left])
                    leftMax = height[left];
                else
                    water += leftMax-height[left];
                left++;
            }
            else {
                if(rightMax <= height[right])
                    rightMax = height[right];
                else
                    water += rightMax-height[right];
                right--;
            }
        }
        return water;
    }
}
