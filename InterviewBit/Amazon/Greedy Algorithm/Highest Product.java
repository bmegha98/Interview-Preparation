/*
Given an array A, of N integers A.Return the highest product possible by multiplying 3 numbers from the array.
NOTE: Solution will fit in a 32-bit signed integer.
Input Format: The first and the only argument is an integer array A.

Output Format: Return the highest possible product.
Constraints: 1 <= N <= 5e5

Example:
Input 1:
A = [1, 2, 3, 4]

Output 1:
24

Explanation 1:
2 * 3 * 4 = 24

Input 2:
A = [0, -1, 3, 100, 70, 50]

Output 2:
350000

Explanation 2:
70 * 50 * 100 = 350000
*/

public class Solution {
    public int maxp3(int[] A) {
        int n = A.length;
        if(n == 3)
            return A[n-1]*A[n-2]*A[n-3];
        Arrays.sort(A);
        int x = A[n-1],y = A[n-2], z = A[n-3];
        
        int firstNeg = A[0], secondNeg = A[1];
        
        return Math.max(firstNeg*secondNeg*x, x*y*z);
    }
}
