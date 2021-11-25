/*
Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
Example 1:

Input:
A[] = {1, 2, 4, 5, 7}
B[] = {5, 6, 3, 4, 8} 
X = 9 
Output: 
1 8
4 5 
5 4
Explanation:
(1, 8), (4, 5), (5, 4) are the
pairs which sum to 9.
Example 2:
Input:
A[] = {-1, -2, 4, -6, 5, 7}
B[] = {6, 3, 4, 0} 
X = 8 
Output:
4 4 
5 3
*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        Arrays.sort(A);
        Arrays.sort(B);
        
        List<pair> tmp = new ArrayList<>();
        int i=0,j = (int)(M-1);
        
        while(i < N && j >= 0) {
            long s = A[i]+B[j];
            if(s == X) {
                pair p = new pair(A[i], B[j]);
                i++;
                tmp.add(p);
            }
            else if(s < X)
                i++;
            else
                j--;
        }
        
        int size = tmp.size();
        pair[] res = new pair[size];
        for(int k=0;k<size;k++)
            res[k] = tmp.get(k);
        return res;
    }
}
