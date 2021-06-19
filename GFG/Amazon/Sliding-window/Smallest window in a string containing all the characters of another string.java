/*
Given two strings S and P. Find the smallest window in the S consisting of all the characters of P.
Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest substring in which "toc" can be found.
Example 2:
Input:
S = "zoomlazapzo"
P = "oza"
Output: 
apzo
Explanation: "apzo" is the smallest substring in which "oza" can be found.
*/

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int m = s.length(),n = p.length();
        if(n > m)
            return "-1";
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        
        for(char ch : p.toCharArray())
            freqP[ch-'a']++;
        
        int start = -1,count = 0,len = Integer.MAX_VALUE;
        int left = 0,right = 0;
        while(right < m) {
            int ind = s.charAt(right)-'a';
            freqS[ind]++;
            if(freqP[ind] > 0 && freqS[ind] <= freqP[ind])
                count++;
            
            if(count == n) {
                while(freqP[s.charAt(left)-'a'] == 0 || 
                    freqS[s.charAt(left)-'a'] > freqP[s.charAt(left)-'a']) {
                    freqS[s.charAt(left)-'a']--;
                    left++;
                }
                if(len > right-left+1) {
                    start = left;
                    len = right-left+1;
                }
            }
            right++;
        }
        if(start == -1)
            return "-1";
        return s.substring(start,start+len);
    }
}
