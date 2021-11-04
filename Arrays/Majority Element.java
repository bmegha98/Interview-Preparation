/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times 
in the array.
Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more than N/2 times, so it is the majority element.
*/

class Solution
{
    static int MooreVotingAlgo(int[] A, int n) {
        int count = 1, res = A[0];
        for(int i=1;i<n;i++) {
            if(A[i] == res)
                count++;
            else
                count--;
            if(count == 0) {
                count = 1;
                res = A[i];
            }
        }
        return res;
    }
    
    static int bitManipulation(int[] A, int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            int tmp = (1 << i), count = 0;
            for(int ele : A) 
                if((ele & tmp) != 0)
                    count++;
            if(count > n/2)
                res |= tmp;
        }
        return res;
    }
    
    static int majorityElement(int a[], int size)
    {
        // your code here
        int candidate = bitManipulation(a,size);
        int freq = 0;
        for(int ele : a)
            if(ele == candidate)
                freq++;
        
        if(freq > (size/2))
            return candidate;
        return -1;
            
    }
}
