/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 

Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105
*/
//T(n) = O(nlogn), Space = O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 1)
            return 1;
        
        //Sort width in asc and height in desc order
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return b[1]-a[1];
            return a[0]-b[0];
        });
        
        List<Integer> count = new ArrayList<>();
        count.add(envelopes[0][1]);
        
        for(int i=1;i<n;i++) {
            if(envelopes[i][1] > count.get(count.size()-1))
                count.add(envelopes[i][1]);
            else {
                int ind = binarySearch(count, envelopes[i][1]);
                count.set(ind, envelopes[i][1]);
            }
        }
        
        return count.size();
    }
    
    private int binarySearch(List<Integer> A, int h) {
        int low = 0, high = A.size()-1, ans = -1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(A.get(mid) >= h) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
}
