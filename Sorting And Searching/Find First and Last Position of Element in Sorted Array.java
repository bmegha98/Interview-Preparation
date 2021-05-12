/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return new int[]{-1,-1};
        if(n == 1)
            return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
        
        int first = getFirstOccurrence(nums,0,n-1,target);
        int second = getLastOccurrence(nums,0,n-1,target);
        
        return new int[]{first,second};
    }
    
    private int getFirstOccurrence(int[] A,int l,int r,int ele) {
        int ans = -1;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(A[m] == ele) {
                ans = m;
                r = m-1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                r = m-1;
        }
        return ans;
    }
    
    private int getLastOccurrence(int[] A,int l,int r,int ele) {
        int ans = -1;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(A[m] == ele) {
                ans = m;
                l = m+1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                r = m-1;
        }
        return ans;
    }
}
