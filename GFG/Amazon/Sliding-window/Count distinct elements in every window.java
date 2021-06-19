/*
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
*/

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        Map<Integer,Integer> aux = new HashMap<>();
        
        int i = 0,j=0,count = 0;
        while(j<k) {
            aux.put(A[j],aux.getOrDefault(A[j],0)+1);
            if(aux.get(A[j]) == 1)
                count++;
            j++;
        }
        
        for(;j<n;j++) {
            res.add(count);
            aux.put(A[j],aux.getOrDefault(A[j],0)+1);
            if(aux.get(A[j]) == 1)
                count++;
            aux.put(A[i],aux.get(A[i])-1);
            if(aux.get(A[i]) == 0)
                count--;
            i++;
        }
        res.add(count);
        return res;
    }
}
