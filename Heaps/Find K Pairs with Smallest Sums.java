/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        
        Queue<int[]> aux = new PriorityQueue<>(1, (p,q)->(nums1[p[0]] + nums2[p[1]]) - (nums1[q[0]] + nums2[q[1]]));
        
        for(int i=0;i<n;i++)
            aux.add(new int[]{0,i});
        
        for(int i=0;i<k&&!aux.isEmpty();i++) {
            int[] tmp = aux.poll();
            List<Integer> l = Arrays.asList(nums1[tmp[0]],nums2[tmp[1]]);
            res.add(l);
            
            if(tmp[0]+1 < m)
                aux.add(new int[]{tmp[0]+1,tmp[1]});
        }
        return res;
    }
}
