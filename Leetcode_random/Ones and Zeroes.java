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
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
*/

class Solution {
    Map<String, Integer> dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new HashMap<>();
        return helper(strs,0,n,m);
    }
    
    private int helper(String[] strs, int start, int numOnes, int numZeros) {
        if(start == strs.length || numOnes+numZeros == 0) {
            return 0;
        }
        
        String key = ""+start+":"+numOnes+":"+numZeros;
        if(dp.containsKey(key))
            return dp.get(key);
        
        int ones = 0, zeros = 0;
        for(char ch : strs[start].toCharArray()) {
            if(ch == '0')
                zeros++;
            else
                ones++;
        }
        
        int exclude = helper(strs,start+1,numOnes,numZeros);
        if(ones <= numOnes && zeros <= numZeros) {
            int include = 1+helper(strs,start+1,numOnes-ones,numZeros-zeros);
            int res = Math.max(include,exclude);
            dp.put(key,res);
            return res;
        }
        
        dp.put(key,exclude);
        return exclude;
    }
}
