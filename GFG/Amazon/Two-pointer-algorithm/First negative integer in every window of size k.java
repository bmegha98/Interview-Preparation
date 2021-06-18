/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
Example 1:

Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
 
Example 2:
Input : 
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0 
*/

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Deque<Integer> aux = new LinkedList<>();
        long[] res = new long[N-K+1];
        int ind = 0,i;
        for(i=0;i<K;i++) {
            if(A[i] < 0)
                while(!aux.isEmpty() && A[aux.peekLast()] >= 0) 
                    aux.pollLast();
            aux.addLast(i);
        }
        
        for(;i<N;i++) {
            if(A[aux.peekFirst()] >= 0)
                res[ind] = 0;
            else
                res[ind] = A[aux.peekFirst()];
            ind++;
            while(!aux.isEmpty() && aux.peekFirst() <= i-K)
                aux.pollFirst();
            
            if(A[i] >= 0) {
                aux.addLast(i);
                continue;
            }
            while(!aux.isEmpty() && A[aux.peekLast()] >= 0) 
                aux.pollLast();
            aux.addLast(i);
        }
        if(A[aux.peekFirst()] >= 0)
            res[ind] = 0;
        else
            res[ind] = A[aux.peekFirst()];
        return res;
    }
}
