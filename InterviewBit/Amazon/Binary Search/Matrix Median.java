/*
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Input Format

The first and only argument given is the integer matrix A.
Output Format

Return the overall median of the matrix A.
Constraints

1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
*/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int m = A.size(), n = A.get(0).size();
        
        int minEle = A.get(0).get(0), maxEle = A.get(0).get(n-1);
        for(int i=1;i<m;i++) {
            if(minEle > A.get(i).get(0))
                minEle = A.get(i).get(0);
            if(maxEle < A.get(i).get(n-1))
                maxEle = A.get(i).get(n-1);
        }
        
        int ans = -1,target = (m*n + 1)/2;
        while(minEle <= maxEle) {
            int mid = minEle+(maxEle-minEle)/2;
            int count = getCount(A, m, n, mid);
            if(count >= target){
                ans = mid;
                maxEle = mid-1;
            }
            else 
                minEle = mid+1;
        }
        return ans;
    }
    private int getCount(ArrayList<ArrayList<Integer>> M, int m, int n, int ele) {
        int count = 0;
        for(int i=0;i<m;i++) 
            count += binarySearch(M.get(i), 0, n-1, ele);
        return count;    
    }
    private int binarySearch(ArrayList<Integer> A,int l,int h, int ele) {
        int ans = h-l+1;
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(A.get(mid) <= ele)
                l = mid+1;
            else {
                ans = mid;
                h = mid-1;
            }
        }
        return ans;
    }
}
