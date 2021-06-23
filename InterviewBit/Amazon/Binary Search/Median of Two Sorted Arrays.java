/*
There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
*/

//Time = O(m+n) , Space = O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        int i=0,j=0,count,m1=0,m2=0;
        
        if((m+n)%2 == 1) {
            for(count=0;count<=(m+n)/2;count++) {
                if(i < m && j < n)
                    m1 = nums1[i]<=nums2[j]?nums1[i++]:nums2[j++];
                else if(i<m)
                    m1 = nums1[i++];
                else
                    m1 = nums2[j++];
            }
            return m1;
        }
        else {
            for(count=0;count<=(m+n)/2;count++) {
                m2 = m1;
                if(i < m && j < n)
                    m1 = nums1[i]<=nums2[j]?nums1[i++]:nums2[j++];
                else if(i<m)
                    m1 = nums1[i++];
                else
                    m1 = nums2[j++];
            }
            return (m1+m2)/2.0;
        }
    }
}

//Time = O(log(min(m,n))) , Space = O(1)
public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int m = a.size(),n = b.size();
        if(m == 0)
            return n%2 == 1 ? b.get(n/2) : (b.get(n/2)+b.get(n/2 - 1))/2.0;
        if(n == 0)
            return m%2 == 1 ? a.get(m/2) : (a.get(m/2)+a.get(m/2 - 1))/2.0;
        if(m > n)           //perform binary search on smaller one
            return findMedianSortedArrays(b,a);
        
        int start =0,end=m;     //m+1 split points
        while(start <= end) {
            int partitionX = start+(end-start)/2;
            int partitionY = (m+n+1)/2 - partitionX;
            
            int maxLeftX = partitionX == 0?Integer.MIN_VALUE:a.get(partitionX-1);
            int maxLeftY = partitionY == 0?Integer.MIN_VALUE:b.get(partitionY-1);
            
            int minRightX = partitionX >= m?Integer.MAX_VALUE:a.get(partitionX);
            int minRightY = partitionY >= n?Integer.MAX_VALUE:b.get(partitionY);
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //Found partition
                if((m+n)%2 == 1)
                    return Math.max(maxLeftX, maxLeftY);
                return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2.0;
            }
            else if(maxLeftX > minRightY)
                end = partitionX-1;         //move left in X
            else
                start = partitionX+1;       //move right in X
        }
        return -1;
    }
}
