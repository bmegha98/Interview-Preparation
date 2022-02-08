/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums,0,nums.length);
        return res;
    }
    
    private void helper(int[] A, int ind, int n) {
        if(ind == n-1) {
            List<Integer> tmp = Arrays.stream(A).boxed()
                .collect(Collectors.toList());
            res.add(tmp);
            return;
        }
        
        for(int i=ind;i<n;i++) {
            swap(A,ind,i);
            helper(A,ind+1,n);
            swap(A,ind,i);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
