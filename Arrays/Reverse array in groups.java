/*
Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.
Example 1:

Input:
N = 5, K = 3
arr[] = {1,2,3,4,5}
Output: 3 2 1 5 4
Explanation: First group consists of elements
1, 2, 3. Second group consists of 4,5.
 

Example 2:

Input:
N = 4, K = 3
arr[] = {5,6,8,9}
Output: 8 6 5 9
 

Your Task:
You don't need to read input or print anything. The task is to complete the function reverseInGroups() which takes the array, N and K as input parameters and 
modifies the array in-place. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/

class Solution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int i = 0;
        while(i < n && i+k-1 < n) {
            int l = i, h = i+k-1;
            while(l<h) {
                int tmp = arr.get(l);
                arr.set(l,arr.get(h));
                arr.set(h,tmp);
                l++;
                h--;
            }
            i += k;
        }
        
        if(i < n) {
            int l = i, h = n-1;
            while(l<h) {
                int tmp = arr.get(l);
                arr.set(l,arr.get(h));
                arr.set(h,tmp);
                l++;
                h--;
            }
        }
    }
}
