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
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an
integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative 
integer , then return 0 for that window.
*/

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int n, int k)
    {
        Deque<Integer> aux = new LinkedList<>();
        int i=0;
        for(;i<k;i++) {
            while(!aux.isEmpty() && A[aux.peekLast()] >= 0)
                aux.pollLast();
            aux.addLast(i);
        }
        long[] res = new long[n-k+1];
        int p = 0;
        for(;i<n;i++) {
            if(A[aux.peek()] >= 0)
                res[p++] = 0;
            else
                res[p++] = A[aux.peekFirst()];
            while(!aux.isEmpty() && A[aux.peekLast()] >= 0)
                aux.pollLast();
            while(!aux.isEmpty() && aux.peekFirst() <= i-k)
                aux.pollFirst();
            aux.addLast(i);
        }
        
        if(A[aux.peek()] >= 0)
            res[p++] = 0;
        else
            res[p++] = A[aux.peekFirst()];
        return res;
    }
}
