/*
Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance 
in the array.Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is
always -1.

Example 1:

Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.
*/

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] res = new long[n];
        Arrays.fill(res,-1);
        
        if(n == 1)
            return res;
        
        Stack<Integer> aux = new Stack<>();
        
        for(int i=n-1;i>=0;i--) {
            while(!aux.isEmpty() && arr[aux.peek()] <= arr[i])
                aux.pop();
            if(!aux.isEmpty())
                res[i] = arr[aux.peek()];
            aux.push(i);
        }
        return res;
    } 
}
