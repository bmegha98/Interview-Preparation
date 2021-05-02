/*
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a
number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number,
and 4 is less than 5.
*/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        
        int[] res = new int[k];
        int canRemove = n-k;
        Stack<Integer> aux = new Stack<>();
     
        for(int i = 0;i<n;i++) {
            while(canRemove > 0 && !aux.isEmpty() && aux.peek() > nums[i])
            {
                aux.pop();
                canRemove--;
            }
            aux.push(nums[i]);
        }
        while(canRemove > 0)
        {
            aux.pop();
            canRemove--;
        }
        
        for(int i = k-1;i>=0;i--) 
            res[i] = aux.pop();
        return res;
    }
}
