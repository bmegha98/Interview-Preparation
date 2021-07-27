/*
Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int n = A.length();
        if(n <= 1)
            return n;
        if(n == 2)
            return A.charAt(0)==A.charAt(1)? 1 : 2;
        
        Set<Character> aux = new HashSet<>();
        int res = 1;
        int i = 0,j=0;
        while(i < n) {
            while(j < n && !aux.contains(A.charAt(j))) {
                aux.add(A.charAt(j));
                j++;
            } 
            res = Math.max(res,j-i);
            if(j == n)
                break;
            aux.remove(A.charAt(i));
            i++;
        }
        
        res = Math.max(res,j-i);
        return res;
    }
}
