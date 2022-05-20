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

//Using swapping
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
    
    private void helper(int[] A, int start, int n) {
        if(start == n-1) {
            List<Integer> tmp = getList(A);
            if(!aux.contains(tmp)) {
                res.add(tmp);
                aux.add(tmp);
            }
            return;
        }
        
        for(int i=start;i<n;i++) {
            if(i>start && A[i] == A[i-1])
                continue;
            swap(A,i,start);
            helper(A,start+1,n);
            swap(A,i,start);
        }
    }
    
    private List<Integer> getList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int ele : arr)
            res.add(ele);
        return res;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

//Using decision tree
//At each loc, we've n choices (max elements that haven't added to the result yet)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        helper(nums,0,n,new ArrayList<>());
        return res;
    }
    
    private void helper(int[] A, int start, int n, List<Integer> tmp) {
        if(start == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i=0;i<n;i++) {
            if(i>0 && A[i] == A[i-1])
                continue;
            if(i < n && A[i] != -11) {
                tmp.add(A[i]);
                A[i] = -11;
                helper(A,start+1,n,tmp);
                A[i] = tmp.remove(tmp.size()-1);
            }
        }
    }
}
