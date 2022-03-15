/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
*/

//Using max-heap, T(n) = O(n^2 logk), Space = O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> aux = new PriorityQueue<>(1,(a,b)->b-a);
        
        for(int[] row : matrix)
            for(int ele : row) {
                aux.add(ele);
                if(aux.size() > k)
                    aux.poll();
            }
        
        return aux.peek();
    }
}

//Using Binary Search T(n) = T(n/2) + O(n) = O(n), Space = O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        
        int res = -1;
        while(min<=max) {
            int mid = min+(max-min)/2;
            int count = ElementsLTE(matrix,n,mid);
            if(count < k)
                min = mid+1;
            else {
                //there can be duplicates
                res = mid;
                max = mid-1;
            }
        }
        return res;
    }
    
    private int ElementsLTE(int[][] M, int n, int ele) {
        int i = n-1, j = 0,count = 0;
        while(i>=0 && j < n) {
            if(M[i][j] > ele)
                i--;
            else {
                count += (i+1);
                j++;
            }
        }
        return count;
    }
}
