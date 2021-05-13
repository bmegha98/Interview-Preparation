//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        if(n==1) 
            return arr[0]==k?1:0;
        Map<Integer,Integer> aux = new HashMap<>();
        int prefixSum = 0, count = 0;
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            if(prefixSum == k)
                count++;
            if(aux.containsKey(prefixSum-k))
                count += aux.get(prefixSum-k);
            aux.put(prefixSum,aux.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
