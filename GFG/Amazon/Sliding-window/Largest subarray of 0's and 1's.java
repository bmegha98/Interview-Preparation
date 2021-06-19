/*
Given an array of 0s and 1s. Find the length of the largest subarray with equal number of 0s and 1s.
replace 0 by -1 and determine max subarray with sum 0.
*/

class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int n)
    {
        Map<Integer,Integer> aux = new HashMap<>();
        aux.put(0,-1);
        
        int prefixSum = 0,len = 0;
        for(int i=0;i<n;i++) {
            prefixSum += arr[i] == 0?-1:1;
            if(aux.containsKey(prefixSum))
                len = Math.max(len,i-aux.get(prefixSum));
            else
                aux.put(prefixSum,i);
        }
        return len;
    }
}
