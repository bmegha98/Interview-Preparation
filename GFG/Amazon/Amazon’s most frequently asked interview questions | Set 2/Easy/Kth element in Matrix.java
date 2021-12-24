/*
Given a N x N matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

Example 1:
Input:
N = 4
mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }}
K = 3
Output: 27
Explanation: 27 is the 3rd smallest element.
 

Example 2:
Input:
N = 4
mat[][] =     {{10, 20, 30, 40}
                   {15, 25, 35, 45}
                   {24, 29, 37, 48}
                   {32, 33, 39, 50}}
K = 7
Output: 30
Explanation: 30 is the 7th smallest element.


Your Task:
You don't need to read input or print anything. Complete the function kthsmallest() which takes the mat, N and K as input parameters and returns the kth smallest element in the matrix.
 

Expected Time Complexity: O(K*Log(N))
Expected Auxiliary Space: O(N)
*/

//Using min-heap
class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        Queue<int[]> minHeap = new PriorityQueue<>(1, (a,b)->mat[a[0]][a[1]] -
                                                        mat[b[0]][b[1]]);
        
        for(int i=0;i<n;i++)
            minHeap.add(new int[]{0,i});
        
        int res = -1;
        while(k-- > 0) {
            int[] curr = minHeap.poll();
            int r = curr[0], c = curr[1];
            res = mat[r][c];
            if(r+1 < n)
                minHeap.add(new int[]{r+1,c});
        }
        return res;
    }
}

//Using binary search
class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int min = mat[0][0], max = mat[n-1][n-1];
        int ans = -1;
        while(min <= max) {
            int m = (max+min)/2;
            int count = ElementsSmallerThan(mat, n, m);
            if(count >= k) {    //There might be duplicates 1 2 3 3 3rd smallest is 3 but #LTE 3 is 4
                ans = m;
                max = m-1;
            }
            else 
                min = m+1;
        }
        return ans;
    }
    
    private static int ElementsSmallerThan(int[][] M, int n, int ele) {
        int i = 0, j = n-1, res = 0;
        while(i<n && j >= 0) {
            if(M[i][j] > ele)
                j--;
            else {
                res += (j+1);
                i++;
            }
        }
        return res;
    }
}
