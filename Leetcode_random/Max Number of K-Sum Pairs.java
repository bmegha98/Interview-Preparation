/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/

//Using Sorting + Two pointer
class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        if(n<2)
            return 0;
        
        Arrays.sort(nums);
        int l = 0, h = n-1, count = 0;
        while(l<h) {
            int s = nums[l]+nums[h];
            if(s == k) {
                l++;
                h--;
                count++;
            }
            else if(s < k)
                l++;
            else
                h--;
        }
        return count;
    }
}

//Using HashMap
class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        if(n<2)
            return 0;
        
        int count = 0;
        Map<Integer,Integer> aux = new HashMap<>();
        
        for(int ele : nums) {
            if(aux.containsKey(k-ele) && aux.get(k-ele) > 0) {
                count++;
                aux.put(k-ele,aux.get(k-ele)-1);
            }
            else 
                aux.put(ele,aux.getOrDefault(ele,0)+1);
        }
        return count;
    }
}
