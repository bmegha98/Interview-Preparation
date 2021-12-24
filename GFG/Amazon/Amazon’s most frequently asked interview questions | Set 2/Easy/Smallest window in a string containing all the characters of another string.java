/*
Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P.  Return "-1" in case 
there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index. 

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Example 2:

Input:
S = "zoomlazapzo"
P = "oza"
Output: 
apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
*/

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int n = s.length(), m = p.length();
        if(n < m)
            return "-1";
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        
        for(char ch : p.toCharArray())
            freqP[ch-'a']++;
        
        int left = 0, right = 0, start = -1, count = 0, minLen = n;
        
        while(right < n) {
            char ch = s.charAt(right);
            
            freqS[ch-'a']++;
            
            if(freqP[ch-'a'] > 0 && freqS[ch-'a'] <= freqP[ch-'a'])
                count++;
            if(count == m) {
                while(left < right && (freqP[s.charAt(left)-'a'] == 0 || 
                    freqS[s.charAt(left)-'a'] > freqP[s.charAt(left)-'a'])) {
                        if(freqS[s.charAt(left)-'a'] > freqP[s.charAt(left)-'a'])
                            freqS[s.charAt(left)-'a']--;
                        left++;
                    }
                
                if(minLen > right-left+1) {
                    minLen = right-left+1;
                    start = left;
                }
            }
            right++;
        }
        
        if(start == -1)
            return "-1";
        return s.substring(start, start+minLen);
    }
}
