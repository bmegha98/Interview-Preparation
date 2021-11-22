/*
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is
1 2 1 3. Number of distinct elements in
this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number
of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number
of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number
of distinct elements in this window are 3.
Example 2:

Input:
N = 3, K = 2
A[] = {4,1,1}
Output: 2 1
*/

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        Map<Integer,Integer> aux = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        int count = 0,left = 0;
        for(int i=0;i<k;i++) {
            aux.put(A[i],aux.getOrDefault(A[i],0)+1);
            if(aux.get(A[i]) == 1)
                count++;
        }
        
        for(int i=k;i<n;i++) {
            res.add(count);
            aux.put(A[left], aux.get(A[left])-1);
            if(aux.get(A[left]) == 0)
                count--;
            left++;
            aux.put(A[i],aux.getOrDefault(A[i],0)+1);
            if(aux.get(A[i]) == 1)
                count++;
        }
        
        res.add(count);
        return res;
    }
}
