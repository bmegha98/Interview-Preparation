/*
Given a String S and an integer K. Find the count of all substrings of length K which have exactly K-1 distinct characters.
Example 1:

Input:
S = "abcc"
K = 2
Output:
1
Explanation:
Possible substrings of length K = 2 are
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct character
Only one valid substring exists {"cc"}. 
Example 2:
Input:
S = "aabab"
K = 3
Output :
3
Explanation:
Possible substrings of length K = 3 are
aab : 2 distinct characters
aba : 2 distinct characters
bab : 2 distinct characters.
All of these Substrings are a possible answer,
so the count is 3.
*/

class Solution {
    static int countOfSubstrings(String s, int k) {
        int n = s.length();
        if(n < k)
            return 0;
        
        int l =0,r = 0,count=0,ans = 0;
        int[] freqS = new int[26];
        
        while(r < k) {
            int ind = s.charAt(r)-'a';
            freqS[ind]++;
            if(freqS[ind] == 1)
                count++;
            r++;
        }
        
        while(r < n) {
            if(count == k-1)
                ans++;
            freqS[s.charAt(r)-'a']++;
            if(freqS[s.charAt(r)-'a'] == 1)
                count++;
            freqS[s.charAt(l)-'a']--;
            if(freqS[s.charAt(l)-'a'] == 0)
                count--;
            l++;
            r++;
        }
        if(count == k-1)
            ans++;
        return ans;
    }
}
