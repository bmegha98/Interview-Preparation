/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

there are 4 cases :
1. A[i] > A[j]
  a. i > j
      f(i,j) = (A[i]-A[j])+(i-j) = (A[i]+i)-(A[j]+j)
  b. i < j
      f(i,j) = (A[i]-A[j])-(i-j) = (A[i]-i)-(A[j]-j)
2. A[i] < A[j]
  a. i > j
      f(i,j) = -(A[i]-A[j])+(i-j) = -A[i]+A[j]+i-j = (A[j]-j)-(A[i]-i)
  b. i < j
      f(i,j) = -(A[i]-A[j])-(i-j) = -A[i]+A[j]-i+j = (A[j]+j)-(A[i]+i)
      
Cases 1a and 2b are equivalent
Cases 1b and 2a are equivalent

So, we only need to consider two cases.

find max value of A[i]+i , max value of A[i]-i
find min value of A[i]+i , min value of A[i]-i

res = max{ max1-min1, max2-min2}
*/

//T(n) = O(n^2)
public class Solution {
    public int maxArr(int[] A) {
        int n = A.length;
        int res = 0;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) 
                res = Math.max(res,Math.abs(A[i]-A[j])+(j-i));
        return res;
    }
}

//T(n) = O(n)
public class Solution {
    public int maxArr(int[] A) {
        int n = A.length;
        
        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = max1, min2 = min1;
        
        for(int i=0;i<n;i++) {
            max1 = Math.max(max1,A[i]+i);
            min1 = Math.min(min1,A[i]+i);
            
            max2 = Math.max(max2,A[i]-i);
            min2 = Math.min(min2,A[i]-i);
        }
        return Math.max(max1-min1, max2-min2);
    }
}

