/*
Given two equally sized 1-D arrays A, B containing N integers each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum C valid sum combinations from all the possible sum combinations.

Problem Constraints
1 <= N <= 105

1 <= A[i] <= 103

1 <= C <= N



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an one-dimensional integer array B of size N.

Third argument is an integer C.



Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

NOTE:

The returned array must be sorted in non-increasing order.



Example Input
Input 1:

 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4


Example Output
Output 1:

 [7, 6]
Output 1:

 [10, 9, 9, 8]


Example Explanation
Explanation 1:

 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:

 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)

Sort arrays in desc order. max sum = A[0]+B[0]
create a max heap of pairs : first elemnt of A with every element of B
second max sum could be A[0]+B[1] or A[1]+B[0]. Since A[0]+B[1] is already present in the heap, therefore add only pair (1,0) i.e. (r+1,c)

*/

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        Queue<int[]> aux = new PriorityQueue<>(1,(a,b)->(A[b[0]]+B[b[1]])-(A[a[0]]+B[a[1]]));
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=n-1;i>=0;i--)
            aux.add(new int[]{n-1,i});
        
        int[] res = new int[C];
        int k = 0;
        
        while(!aux.isEmpty() && C > 0) {
            int[] tmp = aux.poll();
            int r = tmp[0],c = tmp[1];
            res[k] = A[r]+B[c];
            k++;
            
            if(r-1 >= 0) 
                aux.add(new int[]{r-1,c});
            C--;
        }
        return res;
    }
}
