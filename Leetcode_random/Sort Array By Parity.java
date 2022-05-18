/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<high) {
            while(low<=high && nums[low]%2 == 0)
                low++;
            while(high>=low && nums[high]%2 == 1)
                high--;
            
            if(low<high) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
            }
        }
        return nums;
    }
}
