/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
Input Format
First argument is an integer array A
Second argument is an integer B.
Output Format
Return an integer array.

Example Input
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:
 A = [1, 1, 2, 2]
 B = 1

Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]

Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
*/

public class Solution {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        if(B > n)
            return new int[n];
        Map<Integer,Integer> aux = new HashMap<>();
        int i,count = 0;
        for(i=0;i<B;i++) {
            aux.put(A[i],aux.getOrDefault(A[i],0)+1);
            if(aux.get(A[i]) == 1)
                count++;
        }
        
        int[] res = new int[n-B+1];
        int l = 0,k=0;
        for(;i<n;i++) {
            res[k++] = count;
            aux.put(A[l], aux.get(A[l])-1);
            if(aux.get(A[l]) == 0)
                count--;
            l++;
            aux.put(A[i],aux.getOrDefault(A[i],0)+1);
            if(aux.get(A[i]) == 1)
                count++;
        }
        
        res[k] = count;
        return res;
    }
}
