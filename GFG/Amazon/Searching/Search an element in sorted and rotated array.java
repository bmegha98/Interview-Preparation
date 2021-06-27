/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. The task is to find the index of the given 
element K in the array A.

Example 1:

Input:
N = 9
A[] = {5 6,7,8,9,10,1,2,3}
K = 10
Output: 5
Explanation: 10 is found at index 5.
Example 1:

Input:
N = 3
A[] = {3,1,2}
K = 1
Output: 1
*/
//Handles duplicates as well
class Solution 
{ 
    static int Search(int array[], int target)
	{
	    int l = 0,h = array.length-1;
	    while(l <= h) {
	        int m = l+(h-l)/2;
	        if(array[m] == target)
	            return m;
	        if(array[l] == array[m])
	            l++;
	        else if(array[l] < array[m]) {
	            if(target >= array[l] && target <= array[m])
	                h = m-1;
	            else
	                l = m+1;
	        }
	        else {
	            if(target >= array[m] && target <= array[h])
	                l = m+1;
	            else
	                h = m-1;
	        }
	    }
	    return -1;
	}
} 
