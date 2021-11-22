/*
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive 
numbers can be in any order.
Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the
array as inputs and returns the length of the longest subsequence of consecutive integers. 
*/

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	    // add your code here
	    Set<Integer> aux = new HashSet<>();
	    int min = arr[0], max = arr[0];
	    for(int ele : arr) {
	        if(ele > max)
	            max = ele;
	        else if(ele < min)
	            min = ele;
	        aux.add(ele);
	    }
	    
	    int count = 0, res = 0;
	    for(int i = min;i<=max;i++) {
	        if(aux.contains(i))
	            count++;
	        else {
	            res = Math.max(res,count);
	            count = 0;
	        }
	    }
	    
	    return Math.max(res,count);
	}
}

//Using sorting

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	    // add your code here
	    Arrays.sort(arr);
	    int res = 1,count = 1;
	    int right = 1;
	    while(right < N) {
	        if(arr[right]-arr[right-1] == 1)
	            count++;
	        else if(arr[right] == arr[right-1])
	            continue;
	        else {
	            res = Math.max(res, count);
	            count = 1;
	        }
	        right++;
	    }
	    return Math.max(res, count);
	}
}
