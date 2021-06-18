/*
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
Example 1:
Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest substring with K distinct characters.
Example 2:
Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K distinct characters.
*/

class Solution {
    public int longestkSubstr(String s, int k) {
        int l = 0,r = 0, count=0,n = s.length();
        int len = 0;
        int[] freq = new int[26];
        while(r < n) {
            char ch = s.charAt(r);
            freq[ch-'a']++;
            if(freq[ch-'a'] == 1)
                count++;
            
            if(count > k) {
                if(len < r-l)
                    len = r-l;
                while(l < r && count > k) {
                    char tmp = s.charAt(l);
                    freq[tmp-'a']--;
                    l++;
                    if(freq[tmp-'a'] == 0)
                        count--;
                }
            }
            r++;
        }
        
        if(count == k && len < r-l)
            len = r-l;
        return len == 0?-1:len;
    }
}
