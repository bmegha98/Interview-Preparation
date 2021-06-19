/*
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10 
Explanation: First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are {10}, {20}, {30}, {50},
{10}, {70} and {30}. Maximum of these minimums is 70. Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 
2 are {10}, {20}, {30}, {10}, {10}, and {30}. Maximum of these minimums is 30. Third element in output indicates maximum of minimums of all windows of
size 3. Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}. Maximum of these minimums is 20. Similarly other elements of output are computed.
*/

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] ans = new int[n+1];
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> aux = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!aux.isEmpty() && arr[aux.peek()] >= arr[i])
                aux.pop();
            left[i] = aux.isEmpty() ? -1 : aux.peek();
            aux.push(i);
        }
        
        while(!aux.isEmpty()) aux.pop();
        
        for(int i=n-1;i>=0;i--) {
            while(!aux.isEmpty() && arr[aux.peek()] >= arr[i])
                aux.pop();
            right[i] = aux.isEmpty() ? n : aux.peek();
            aux.push(i);
        }
        
        for(int i=0;i<n;i++) {
            int len = right[i]-left[i]-1;
            ans[len] = Math.max(ans[len],arr[i]);
        }
        
        for(int i=n-1;i>0;i--)
            ans[i] = Math.max(ans[i],ans[i+1]);
            
        int[] res = new int[n];
        for(int i=0;i<n;i++)
            res[i] = ans[i+1];
        return res;
    }
}
