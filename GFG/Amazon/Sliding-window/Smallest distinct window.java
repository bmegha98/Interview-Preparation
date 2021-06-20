/*
Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca”.
Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
*/

class Solution {
    public String findSubString( String str) {
        int n = str.length();
        if(n == 1)
            return str;
        
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        
        int m = 0;
        for(char ch : str.toCharArray()) 
            if(freqT[ch] == 0) {
                freqT[ch]++;
                m++;
            }
        
        int r = 0,l = 0,count = 0,len = n,start = 0;
        while(r < n) {
            int ind = str.charAt(r);
            freqS[ind]++;
            if(freqT[ind] > 0 && freqS[ind] <= freqT[ind])
                count++;
            if(count == m) {
                while(freqT[str.charAt(l)] == 0 || 
                    freqS[str.charAt(l)] > freqT[str.charAt(l)]) {
                    freqS[str.charAt(l)]--;
                    l++;
                }
                if(len > r-l+1) {
                    len = r-l+1;
                    start = l;
                }
            }
            r++;
        }
        return str.substring(start,start+len);
    }
}
