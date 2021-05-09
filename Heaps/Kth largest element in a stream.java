/*
Given an input stream arr[] of n integers, find the kth largest element for each element in the stream.

Example 1:

Input:
k = 4, n = 6
arr[] = {1, 2, 3, 4, 5, 6}
Output:
-1 -1 -1 1 2 3
Explanation:
k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1.
For 5, the 4th largest element is 2.
for 6, the 4th largest element is 3.
*/

class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        int[] res = new int[n];
        Queue<Integer> aux = new PriorityQueue<>();
        for(int i =0;i<n;i++) {
            aux.add(arr[i]);
            int len = aux.size();
            if(len < k)
                res[i] = -1;
            else if(len == k)
                res[i] = aux.peek();
            else{
                aux.poll();
                res[i] = aux.peek();
            }
        }
        return res;
    }
}
