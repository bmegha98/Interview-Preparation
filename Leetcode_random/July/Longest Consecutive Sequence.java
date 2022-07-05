/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

// Brute-force using sorting 

//Optimized
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        
        Set<Integer> aux = new HashSet<>();
        
        for(int ele : nums) 
            aux.add(ele);
            
        
        int res = 0;
        for(int ele : nums) {
            if(!aux.contains(ele-1)) { // This will eventually be traversed with ele-1
                int len = 1;
                while(aux.contains(ele+1)) {
                    len++;
                    ele++;
                }

                res = Math.max(res,len);
            }
        }
        
        return res;
    }
}
