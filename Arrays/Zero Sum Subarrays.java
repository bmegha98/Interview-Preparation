/*
You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.
Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]
*/

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        Map<Long, Long> freqMap = new HashMap<>();
        long res = 0;
        long prefixSum = 0;
        
        for(int i=0;i<n;i++) {
            prefixSum += arr[i];
            
            if(prefixSum == 0)
                res++;
            if(freqMap.containsKey(prefixSum))
                res += freqMap.get(prefixSum);
            freqMap.put(prefixSum, freqMap.getOrDefault(prefixSum,0L)+1);
        }
        
        return res;
    }
}
