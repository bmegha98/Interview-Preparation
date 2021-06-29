/*
Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.
Example 1:

Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5
Example 2:

Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5
*/

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        if(n > m)
            return medianOfArrays(m,n,b,a);
        
        int l = 0, h = n;
        while(l <= h) {
            int partitionX = l+(h-l)/2;
            int partitionY = ((n+m+1)/2)-partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a[partitionX-1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b[partitionY-1];
            
            int minRightX = partitionX == n ? Integer.MAX_VALUE : a[partitionX];
            int minRightY = partitionY == m ? Integer.MAX_VALUE : b[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //found
                if((m+n)%2 == 1)
                    return Math.max(maxLeftX, maxLeftY);
                return (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2.0;
            }
            else if(maxLeftX > minRightY)
                h = partitionX-1;
            else
                l = partitionX+1;
        }
        return -1;
    }
}
