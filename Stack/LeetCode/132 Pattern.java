/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return false;
//         int a = nums[0];
//         for(int j = 0;j<n;j++) {
//             a = Math.min(a, nums[j]);
//             if(a == nums[j])
//                 continue;
            
//             int b = nums[j];
//             for(int k = j+1;k<n;k++) {
//                 int c = nums[k];
//                 if(a < c && c < b)
//                     return true;
//             }
//         }
//         return false;
        
        Stack<Integer> aux = new Stack<>();
        int S3 = Integer.MIN_VALUE;
        
        for(int i = n-1;i>=0;i--) {
            if(nums[i] < S3)
                return true;
            while(!aux.isEmpty() && aux.peek() < nums[i])
                S3 = aux.pop();
            aux.push(nums[i]);
        }
        return false;
    }
}
