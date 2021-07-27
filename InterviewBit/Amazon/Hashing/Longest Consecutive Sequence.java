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

*/

//Using sorting
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return n;
        Arrays.sort(nums);
        //System.out.println(nums);
        int res = 1, i = 0, j;
        while(i<n) {
            j = i+1;
            //System.out.println(i + ": "+j);
            while(j<n && nums[j]-nums[j-1] <= 1)      //[0,1,1,2] => 3
                j++;
            res = Math.max(res,nums[j-1]-nums[i]+1);
            i = j;
        }
        return res;
    }
}

//Using Set
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return n;
        Set<Integer> aux = new HashSet<>();
        for(int ele : nums)
            aux.add(ele);
        
        int res = 1;
        for(int ele : nums) {
            if(!aux.contains(ele-1)) {
                int x = ele+1;
                while(aux.contains(x))
                    x++;
                res = Math.max(res,x-ele);
            }
        }
        return res;
    }
}
