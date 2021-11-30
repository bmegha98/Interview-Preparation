/*
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the 
final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.
*/

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m)
            return kthElement(arr2, arr1, m, n, k);
        
        int start = Math.max(0,k-m), end = Math.min(k,n);
        
        while(start <= end) {
            
            int partitionX = (start+end)/2;
            int partitionY = k-partitionX;
            
            int XleftMax = partitionX == 0?Integer.MIN_VALUE:arr1[partitionX-1];
            int YleftMax = partitionY == 0?Integer.MIN_VALUE:arr2[partitionY-1];
            int XrightMax = partitionX == n?Integer.MAX_VALUE:arr1[partitionX];
            int YrightMax = partitionY == m?Integer.MAX_VALUE:arr2[partitionY];
            
            if(XleftMax <= YrightMax && YleftMax <= XrightMax)
                return Math.max(XleftMax, YleftMax);
            if(XleftMax > YrightMax)
                end = partitionX-1;
            else
                start = partitionX+1;
        }
        return -1;
    }
}
