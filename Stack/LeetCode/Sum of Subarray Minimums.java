/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer 
modulo 109 + 7.
Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0];
        // int sum = 0;
        // for(int i =0;i<n;i++) {
        //     int minEle = arr[i];
        //     for(int j = i;j<n;j++) {
        //         minEle = Math.min(minEle, arr[j]);
        //         sum += minEle;
        //         sum %= 1000000007;                
        //     }
        // }
        // return sum;
        
        long sum = 0,mod = (int)1e9 + 7;
        Stack<Integer> aux = new Stack<>();
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, n);
        
        for(int i = 0;i<n;i++) {
            while(!aux.isEmpty() && arr[aux.peek()] >= arr[i])
                rightMin[aux.pop()] = i;
            if(!aux.isEmpty())
                leftMin[i] = aux.peek();
            aux.push(i);
        }
        
        for(int i =0;i<n;i++) {
            sum = (sum + (long)arr[i]*(i-leftMin[i])*(rightMin[i]-i)) % mod;
        }
        return (int)sum;
    }
}
