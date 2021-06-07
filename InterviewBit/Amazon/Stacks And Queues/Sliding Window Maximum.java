/*
Given an array of integers A. There is a sliding window of size B which
is moving from the very left of the array to the very right.
You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.
The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	         Max
———————————-	        ————————-
[1 3 -1] -3 5 3 6 7	     3
1 [3 -1 -3] 5 3 6 7	     3
1 3 [-1 -3 5] 3 6 7	     5
1 3 -1 [-3 5 3] 6 7	     5
1 3 -1 -3 [5 3 6] 7	     6
1 3 -1 -3 5 [3 6 7]	     7
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        if(n < 2 || B == 1)
            return new ArrayList<>(A);
        
        Deque<Integer> aux = new LinkedList<>();
        int i;
        for(i = 0;i<B && i < n;i++) {
            while(!aux.isEmpty() && A.get(aux.peekLast()) <= A.get(i))
                aux.pollLast();
            aux.addLast(i);
        }
        
        for(;i<n;i++) {
            res.add(A.get(aux.peekFirst()));
            while(!aux.isEmpty() && A.get(aux.peekLast()) <= A.get(i))
                aux.pollLast();
            while(!aux.isEmpty() && aux.peekFirst() <= i-B)
                aux.pollFirst();
            aux.addLast(i);
        }
        res.add(A.get(aux.peekFirst()));
        return res;
    }
}
