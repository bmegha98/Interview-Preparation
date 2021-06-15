/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
*/

public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int n = A.size();
        
        int l = 0, r = 0,start = 0,len = 0;
        while(r < n) {
            if(A.get(r) == 1)
                r++;
            else if(B > 0) {
                r++;
                B--;
            } 
            else {
                if(len < r-l) {
                    start = l;
                    len = r-l;
                }
                while(l < r && A.get(l) == 1)
                    l++;
                
                B++;
                l++;
            }
            if(len < r-l) {
                start = l;
                len = r-l;
            }
        }
        
        if(len < r-l) {
            start = l;
            len = r-l;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=start;i<start+len;i++)
            res.add(i);
        return res;
    }
}
