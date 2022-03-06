/*
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10 
Explanation: 
1.First element in output
indicates maximum of minimums of all
windows of size 1.
2.Minimums of windows of size 1 are {10},
 {20}, {30}, {50},{10}, {70} and {30}. 
 Maximum of these minimums is 70. 
3. Second element in output indicates
maximum of minimums of all windows of
size 2. 
4. Minimums of windows of size 2
are {10}, {20}, {30}, {10}, {10}, and
{30}.
5. Maximum of these minimums is 30 
Third element in output indicates
maximum of minimums of all windows of
size 3. 
6. Minimums of windows of size 3
are {10}, {20}, {10}, {10} and {10}.
7.Maximum of these minimums is 20. 
Similarly other elements of output are
computed.
Example 2:

Input:
N = 3
arr[] = {10,20,30}
Output: 30 20 10
Explanation: First element in output
indicates maximum of minimums of all
windows of size 1.Minimums of windows
of size 1 are {10} , {20} , {30}.
Maximum of these minimums are 30 and
similarly other outputs can be computed
Your Task:
The task is to complete the function maxOfMin() which takes the array arr[] and its size N as inputs and finds the maximum of minimum of every window size and 
returns an array containing the result. 
*/

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        int[] left = new int[n];
        Arrays.fill(left,-1);
        int[] right = new int[n];
        Arrays.fill(right,n);
        
        //next smallest element on right
        Stack<Integer> aux = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!aux.isEmpty() && arr[aux.peek()] >= arr[i])
                aux.pop();
            if(!aux.isEmpty())
                right[i] = aux.peek();
            aux.push(i);
        }
        
        aux.clear();
        
        //next smallest element on left
        for(int i=0;i<n;i++) {
            while(!aux.isEmpty() && arr[aux.peek()] >= arr[i])
                aux.pop();
            if(!aux.isEmpty())
                left[i] = aux.peek();
            aux.push(i);
        }
        
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int windowSize = right[i]-left[i]-1;
            //A[i] will be candidate for window of size windowSize
            res[windowSize-1] = Math.max(res[windowSize-1],arr[i]);
        }
        
        //res[i] >= res[i+1] always since if res[i] is min of window of size i
        //then it will also be min of window of size i+1
        
        for(int i=n-2;i>=0;i--)
            res[i] = Math.max(res[i],res[i+1]);
        return res;
    }
}
