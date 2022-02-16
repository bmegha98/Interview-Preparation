/*
Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of 
elements.
Note: All elements of this array should be part of exactly one partition.

Example 1:

Input: 
N = 5
a[] = {2,1,4,5,6}
K = 3
Output: 
1
Explanation: we can divide above array 
into 3 parts with equal sum as (2, 4), 
(1, 5), (6)
Example 2:

Input: 
N = 5 
a[] = {2,1,5,5,6}
K = 3
Output: 
0
Explanation: It is not possible to divide
above array into 3 parts with equal sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isKPartitionPossible() which takes the array a[], the size of the array N, 
and the value of K as inputs and returns true(same as 1) if possible, otherwise false(same as 0).
*/

class Solution
{
    int[] aux;
    public boolean isKPartitionPossible(int a[], int n, int k) {
        
	    // Your code here
	    int sum = 0,maxEle = Integer.MIN_VALUE;
	    for(int ele : a) {
	        sum += ele;
	        maxEle = Math.max(maxEle,ele);
	    }
	    if(sum%k != 0)
	        return false;
	    sum /= k;
	    if(maxEle > sum)
	        return false;
	    aux = new int[k];
	    Arrays.fill(aux,sum);
	    
	    return helper(a,0,n,k);
    }
    
    private boolean helper(int[] A, int ind, int n,int k) {
        if(ind == n)
            return true;
        
        for(int i=0;i<k;i++)
            if(A[ind] <= aux[i]) {
                aux[i] -= A[ind];
                if(helper(A,ind+1,n,k))
                    return true;
                aux[i] += A[ind];
            }
        return false;
    }
}
