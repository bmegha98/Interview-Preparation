/*
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.
*/

class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        if(n == 1)
            return A[0] >= K?1:-1;
        
        // int res = n+1;
        // for(int i =0;i<n;i++) {
        //     int s = 0;
        //     for(int j =i;j<n;j++) {
        //         s += A[j];
        //         if(s >= K)
        //             res = Math.min(res, j-i+1);
        //     }
        // }
        // return res == n+1?-1:res;
        
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i = 1;i<n;i++)
            prefix[i] = prefix[i-1]+A[i];
        
        int res = -1;
        Deque<Integer> aux = new LinkedList<>();
        
        for(int i = 0;i<n;i++) {
            if(prefix[i] >= K) {
                if(res == -1)
                    res = i+1;
                else
                    res = Math.min(res,i+1);
            }
            while(!aux.isEmpty() && prefix[i]-prefix[aux.peekFirst()] >= K) {
                if(res == -1)
                    res = i-aux.pollFirst();
                else
                    res = Math.min(res, i-aux.pollFirst());
            }
            while(!aux.isEmpty() && prefix[i] < prefix[aux.peekLast()])
                aux.pollLast();
            aux.addLast(i);
        }
        return res;
    }
}
