/*
Given an array Arr[] of size N. For every element in the array, the task is to find the index of the farthest element in the array to the right which is
smaller than the current element. If no such number exists then print -1.
Note: 0 based indexing.


Example 1:

Input: 
N=5
Arr[] = {3, 1, 5, 2, 4}
Output: 
3 -1 4 -1 -1
Explanation:
Arr[3] is the farthest smallest element
to the right of Arr[0].
Arr[4] is the farthest smallest element
to the right of Arr[2].
And for the rest of the elements, there is
no smaller element to their right.
Example 2:

Input: 
N=5
Arr[] = {1, 2, 3, 4, 0}
Output: 
4 4 4 4 -1

Your Task: 
You don't need to read input or print anything. Your task is to complete the function farNumber() which takes the N (number of elements in Array Arr) ,
Arr[], and returns the array of farthest element to the right for every element of the array.
*/

//Brute-force

class Solution 
{ 
    static int[] farNumber(int N, int Arr[])
	{    
	    int[] res = new int[N];
        Arrays.fill(res,-1);
        
        for(int i=0;i<N-1;i++) {
            boolean found = false;
            int j = N-1;
            for(;j>i;j--)
                if(Arr[j] < Arr[i]) {
                    found = true;
                    break;
                }
            if(found)
                res[i] = j;
        }
        return res;
	}
}

//Optimized, T(n) = O(nlogn), Space = O(n)

class Solution 
{ 
    static int[] farNumber(int N, int Arr[])
	{    
	    int[] res = new int[N];
        Arrays.fill(res,-1);
        
        int[] suffixMin = new int[N];
        suffixMin[N-1] = Arr[N-1];

        for(int i=N-2;i>=0;i--) 
            suffixMin[i] = Math.min(Arr[i],suffixMin[i+1]);
        
        for(int i=0;i<N-1;i++) {
            int pos = binarySearch(suffixMin,i+1,N-1,Arr[i]);
            res[i] = pos;
        }
        return res;
	}
	
	static int binarySearch(int[] A, int l, int h, int ele) {
	    int ans = -1;
	    while(l <= h) {
	        int m = l+(h-l)/2;
	        if(A[m] < ele) {
	            ans = m;
	            l = m+1;
	        }
	        else
	            h = m-1;
	    }
	    return ans;
	}
}
