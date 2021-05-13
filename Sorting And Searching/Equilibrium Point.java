/*
Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array. 
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
*/

//T(n) = O(n) , space = O(n)
class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if(n == 1)
            return 1;
        long left[] = new long[n];
        left[0] = 0L;
        for(int i=1;i<n;i++)
            left[i] = left[i-1]+arr[i-1];
        long sum = left[n-1]+arr[n-1];
        for(int i=0;i<n;i++) {
            long rightSum = sum-left[i]-arr[i];
            if(left[i]==rightSum)
                return i+1;
        }
        return -1;
    }
}

//T(n) = O(n) , space = O(1)

class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if(n == 1)
            return 1;
        if(n == 2)
            return -1;
        long left = arr[0];
        long total = 0;
        for(long ele : arr)
            total += ele;
            
        for(int i=1;i<n;i++) {
            long right = total-left-arr[i];
            if(left == right)
                return i+1;
            left += arr[i];
        }
        return -1;
    }
}
