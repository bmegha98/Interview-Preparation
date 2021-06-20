/*
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given
value K.
Example 1:
Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
*/

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int n, int k) {
        Map<Integer,Integer> aux = new HashMap<>();
        
        int prefix = 0,len = 0;
        for(int i=0;i<n;i++) {
            prefix += A[i];
            if(prefix == k)
                len = Math.max(len,i+1);
            else if(aux.containsKey(prefix-k))
                len = Math.max(len,i-aux.get(prefix-k));
            if(!aux.containsKey(prefix))
                aux.put(prefix,i);
        }
        return len;
    }
}
