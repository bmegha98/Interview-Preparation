/*
Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides
of triangles. 
Example 1:
Input: 
n = 3
arr[] = {3, 5, 4}
Output: 
1
Explanation: 
A triangle is possible with all the elements 5, 3 and 4.
Example 2:
Input: 
n = 5
arr[] = {6, 4, 9, 7, 8}
Output: 
10
Explanation: 
There are 10 triangles possible  with the given elements like (6,4,9), (6,7,8),...
*/

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int count = 0;
        for(int i=n-1;i>=2;i--) {
            int l=0,h=i-1;
            while(l<h) {
                int s = arr[l]+arr[h];
                if(s > arr[i]) {
                    count += (h-l);
                    h--;
                }
                else
                    l++;
            }
        }
        return count;
    }
}
