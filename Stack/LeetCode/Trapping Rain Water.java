//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3)
            return 0;
        //T(n) = O(n), space = O(n)
//         int water = 0;
//         int[] left = new int[n];
//         int[] right = new int[n];
//         left[0] = height[0];
//         for(int i =1;i<n;i++)
//             left[i] = Math.max(left[i-1], height[i]);
//         right[n-1] = height[n-1];
//         for(int i=n-2;i>=0;i--)
//             right[i] = Math.max(right[i+1], height[i]);
        
//         for(int i=0;i<n;i++)
//             water += (Math.min(left[i], right[i])-height[i]);
//         return water;
        
        int left = 0, right = n-1, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int water = 0;
        while(left <= right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax > height[left])
                    water += (leftMax - height[left]);
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax > height[right])
                    water += (rightMax - height[right]);
                right--;
            }
        }
        return water;
    }
}
