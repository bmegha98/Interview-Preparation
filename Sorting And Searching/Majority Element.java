/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/

class Solution {
    private int usingSorting(int[] A, int n) {
        Arrays.sort(A);
        return A[n/2];
    }
    
    private int usingBit(int[] A, int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            int count = 0;
            for(int ele : A)
                if((ele&(1<<i)) != 0)
                    count++;
            if(count > n/2)
                res |= (1<<i);
        }
        return res;
    }
    
    private int usingMooreVoting(int[] A, int n) {
        int majority = A[0], count = 1;
        for(int i=1;i<n;i++) {
            if(A[i] == majority)
                count++;
            else
                count--;
            if(count == 0) {
                majority = A[i];
                count = 1;
            }
        }
        return majority;
    }
    
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        //return usingSorting(nums,n);
        //return usingBit(nums,n);
        return usingMooreVoting(nums,n);
    }
}
