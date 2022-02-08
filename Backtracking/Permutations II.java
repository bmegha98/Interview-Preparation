/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

//Using Set
class Solution {
    List<List<Integer>> res;
    Set<List<Integer>> aux;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        aux = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        helper(nums,0,n);
        return res;
    }
    private void helper(int[] A, int ind, int n) {
        if(ind == n-1) {
            List<Integer> tmp = Arrays.stream(A).boxed().collect(Collectors.toList());
            if(!aux.contains(tmp)) {
                aux.add(tmp);
                res.add(tmp);
            }
            return;
        }
        for(int i=ind;i<n;i++) {
            if(i>ind && A[i] == A[i-1])
                continue;
            swap(A,i,ind);
            helper(A,ind+1,n);
            swap(A,i,ind);
        }
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

//Using next permutation
//Using include/exclude logic

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),n);
        return res;
    }
    private void helper(int[] A, int ind, List<Integer> tmp, int n) {
        if(ind >= n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<n;i++) {
            if(i>0 && A[i] == A[i-1])
                continue;
            if(i<n && A[i] != -11) {
                tmp.add(A[i]);
                A[i] = -11;
                helper(A,ind+1,tmp,n);
                A[i] = tmp.remove(tmp.size()-1);
            }
        }
    }
}
