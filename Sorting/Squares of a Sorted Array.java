/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
*/

//T(n) = O(nlogn)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++)
            nums[i]*= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}

//T(n) = O(n) 

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n && nums[i]<0)
            i++;
        int negInd = i-1;
        int[] res = new int[n];
        int k =0;
        while(i < n && negInd >= 0) {
            int first = nums[i]*nums[i];
            int second = nums[negInd]*nums[negInd];
            if(first <= second)
            {
                res[k] = first;
                i++;
            }
            else {
                res[k] = second;
                negInd--;
            }
            k++;
        }
        
        while(i < n) {
            res[k++] = nums[i]*nums[i];
            i++;
        }
        while(negInd >= 0) {
            res[k++] = nums[negInd]*nums[negInd];
            negInd--;
        }
        return res;
    }
}
