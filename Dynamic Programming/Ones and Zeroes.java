/*
You are given an array of binary strings strs and two integers m and n.
Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
A set x is a subset of a set y if all elements of x are also elements of y.
Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
*/

class Solution {
    Map<String,Integer> aux;
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        aux = new HashMap<>();
        return largestSubset(strs,m,n,size);
    }
    
    private int largestSubset(String[] strs, int m, int n, int size) {
        if(size == 0)
            return 0;
        if(m == 0 && n == 0)
            return 0;
        
        int[] count = new int[2];
        for(char ch : strs[size-1].toCharArray())
            count[ch-'0']++;
        String key = size+"->"+m+"->"+n;
        if(aux.containsKey(key))
            return aux.get(key);
        
        int inclusive = 0;
        int exclusive = largestSubset(strs,m,n,size-1);
        if(count[0] <= m && count[1] <= n)
            inclusive =  1+largestSubset(strs,m-count[0],n-count[1],size-1);
        int ans = Math.max(inclusive, exclusive);
        aux.put(key, ans);
        return ans;
    }
}
