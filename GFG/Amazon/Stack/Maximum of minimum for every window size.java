/*
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10 
Explanation: First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are {10}, {20}, {30}, {50},
{10}, {70} and {30}. Maximum of these minimums is 70. Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2
are {10}, {20}, {30}, {10}, {10}, and {30}. Maximum of these minimums is 30 Third element in output indicates maximum of minimums of all windows of
size 3. Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}. Maximum of these minimums is 20. Similarly other elements of output are computed.
*/

//Brute force : O(n^3)

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        List<Integer> tmp = new ArrayList<>();
        
        for(int w = 1;w<=n;w++) {
            int maxEle = Integer.MIN_VALUE;
            for(int i=0;i<=n-w;i++) {
                int minEle = arr[i];
                for(int j=1;j<w;j++) 
                    minEle = Math.min(minEle,arr[i+j]);
                maxEle = Math.max(maxEle,minEle);
            }
            tmp.add(maxEle);
        }
        
        int[] res = new int[tmp.size()];
        for(int i =0;i<tmp.size();i++)
            res[i] = tmp.get(i);
        return res;
    }
}

//Optimized Method 
/*
for each element A[i] ,determine left[i] and right[i] where left[i] = index of last element smaller than A[i] on the left and right[i] = index of next smaller
element. So, A[i] will be min element of window of size ,len = right[i]-left[i]-1. 
ans[len] = max{ans[len], A[i]}

ans[i] would always be greater than or equal to ans[i+1].
So, fill the unfilled entries by taking max{ans[i],ans[i+1]}
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
