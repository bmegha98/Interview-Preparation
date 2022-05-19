/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and
nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
*/

//T(n) = O(n^3), Space = O(1)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return false;
        
        for(int i=0;i<=n-3;i++)
            for(int j=i+1;j<=n-2;j++)
                for(int k=j+1;k<n;k++)
                    if(nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
        return false;
    }
}

//T(n) = O(n^2), Space = O(1)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return false;
        int a = Integer.MAX_VALUE;
        
        for(int j=0;j<n-1;j++) {
            a = Math.min(a, nums[j]);
            if(a == nums[j])
                continue;
            
            for(int k=j+1;k<n;k++)
                if(a < nums[k] && nums[k] < nums[j])
                    return true;
        }
        
        return false;
    }
}

//T(n) = O(n), Space = O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return false;
        Stack<Integer> aux = new Stack<>();
        int c = Integer.MIN_VALUE;
        
        for(int i=n-1;i>=0;i--) {
            if(nums[i] < c)
                return true;
            while(!aux.isEmpty() && aux.peek() < nums[i])
                c = aux.pop();
            aux.push(nums[i]);
        }
        
        return false;
    }
}
