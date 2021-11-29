/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element key. The task is to find the index of the given element key in the array A.

Example 1:

Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
Output:
5
Explanation: 10 is found at index 5.
Example 2:

Input:
N = 4
A[] = {3, 5, 1, 2}
key = 6
Output:
-1
Explanation: There is no element that has value 6.
*/
//Works with duplicates too
class Solution
{
    int search(int A[], int l, int h, int key)
    {
        // Complete this function
        while(l<=h) {
            int m = l+(h-l)/2;
            if(A[m] == key)
                return m;
            if(A[l] == A[m])
                l++;
            else if(A[l]<A[m]){
                if(A[l] <= key && key <= A[m])
                    h = m-1;
                else
                    l = m+1;
            }
            else {
                if(key >= A[m] && key <= A[h])
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return -1;
    }
}
