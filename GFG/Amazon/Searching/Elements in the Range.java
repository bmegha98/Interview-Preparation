/*
Given an array arr[] containing positive elements. ‘A’ and ‘B’ are two numbers defining a range. The task is to check if the array contains all elements in the 
given range.
Example 1:

Input: N = 7, A = 2, B = 5
arr[] =  {1, 4, 5, 2, 7, 8, 3}
Output: Yes
Explanation: It has elements between range 2-5 i.e 2,3,4,5
Example 2:

Input: N = 7, A = 2, B = 6
arr[] = {1, 4, 5, 2, 7, 8, 3}
Output: No
Explanation: Array does not contain 6.
*/

//Using Set
class Solution
{
    boolean check_elements(long arr[], int n, int A, int B)
    {
        Set<Long> aux = new HashSet<>();
        for(long ele : arr)
            aux.add(ele);
        
        while(A <= B) {
            if(!aux.contains(Long.valueOf(A)))
                return false;
            A++;
        }
        return true;
    }
}

//Space optimized
class Solution
{
    boolean check_elements(long arr[], int n, int A, int B)
    {
        long low = Long.valueOf(A), high = Long.valueOf(B);
        int count = 0;
        for(int i=0;i<n;i++) 
            if(Math.abs(arr[i]) >= low && Math.abs(arr[i]) <= high) {
                int ind = (int)(Math.abs(arr[i])-low);
                if(ind >= 0 && ind < n && arr[ind] > 0)
                    arr[ind] *= -1;
            }
        
        
        for(int i=0;i<=B-A&&i<n;i++) {
            if(arr[i] > 0)
                return false;
            count++;
        }
        
        return count == B-A+1;
    }
}
