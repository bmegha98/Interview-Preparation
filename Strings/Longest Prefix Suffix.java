/*
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper 
prefix and suffix. 
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper prefix and suffix. 
Your task:
You do not need to read any input or print anything. The task is to complete the function lps(), which takes a string as input and returns an integer.
*/

class Solution {
    int lps(String s) {
        // code here
        int n = s.length();
        if(n == 1)
            return 0;
        
        int[] tmp = new int[n];
        tmp[0] = 0;
        int i=0,j=1;
        while(j<n) {
            if(s.charAt(i) == s.charAt(j)) {
                tmp[j] = i+1;
                i++;
                j++;
            }
            else {
                if(i != 0)
                    i = tmp[i-1];
                else {
                    tmp[j] = 0;
                    j++;
                }
            }
        }
        return tmp[n-1];
    }
}
