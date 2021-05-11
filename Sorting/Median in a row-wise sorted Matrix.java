/*
Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
*/

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here  
        int requiredCount = (r*c +1)/2;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i =0;i<r;i++) {
            if(matrix[i][0] < min)
                min = matrix[i][0];
            if(matrix[i][c-1] > max)
                max = matrix[i][c-1];
        }
        
        int ans = -1;
        
        while(min <= max) {
            int mid = min+(max-min)/2;
            int count = getCount(matrix,r,c,mid);
            //System.out.println("count for mid "+mid+" is : "+count);
            if(count < requiredCount)
                min = mid+1;
            else {
                ans = mid;
                max = mid-1;
            }
        }
        return ans;
    }
    
    private int getCount(int A[][], int r, int c, int ele) {
        int count = 0;
        for(int i=0;i<r;i++) {
            int ind = binarySearch(A[i], 0, c-1, ele);
            count += ind;
        }
        return count;
    }
    
    private int binarySearch(int[] A, int l, int h, int ele) {
        int ans = -1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A[m] <= ele) 
                l = m+1;
            else {
                ans = m;
                h = m-1;
            }
        }
        return ans==-1?h+1:ans;
    }
}
