/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..
., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
*/

//Two scans 

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1)
            return nums[0] == target?0:-1;
        int pivot = findPivot(nums,0,n-1);
        if(nums[pivot] == target)
            return pivot;
        int res = -1;
        if(target > nums[pivot] && target <= nums[n-1])
            res = binarySearch(nums,pivot+1,n-1,target);
        if(res != -1)
            return res;
        return binarySearch(nums,0,pivot-1,target);
    }
    
    private int findPivot(int A[], int l,int r) {
        while(l <= r) {
            int m = l+(r-l)/2;
            if((m==0||A[m] < A[m-1])&&(m == A.length-1||A[m] < A[m+1]))
                return m;
            if(A[m] <= A[r])
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
    
    private int binarySearch(int A[], int l,int r,int ele) {
        while(l <= r){
            int m = l+(r-l)/2;
            if(A[m] == ele)
                return m;
            if(A[m] < ele)
                l = m+1;
            else
                r = m-1;
        }
        return -1;
    }
}

//Single scan

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1)
            return nums[0] == target?0:-1;
        int l = 0,h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(nums[m] == target)
                return m;
            if(nums[l] <= nums[m]) {
                //First half is sorted
                if(target >= nums[l] && target <= nums[m])
                    h = m-1;
                else
                    l = m+1;
            }
            else {
                //second half is sorted
                if(target >= nums[m] && target <= nums[h])
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return -1;
    }
}
