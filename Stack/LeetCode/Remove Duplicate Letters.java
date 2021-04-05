/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order 
among all possible results.
Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        if(n <= 1)
            return s;
        int[] freq = new int[26];
        char[] strArray = s.toCharArray();
        for(char ch : strArray)
            freq[ch-'a']++;
        boolean[] inResult = new boolean[26];
        StringBuilder res = new StringBuilder();
        
        for(char ch : strArray)
        {
            if(res.length() == 0)
            {
                res.append(ch);
                freq[ch-'a']--;
                inResult[ch-'a'] = true;
            }
            else if(inResult[ch-'a'])
            {
                freq[ch-'a']--;
                continue;
            }
            else
            {
                char last = res.charAt(res.length()-1);
                while(res.length() > 0 && last > ch && freq[last-'a'] > 0)
                {
                    res.deleteCharAt(res.length()-1);
                    inResult[last-'a'] = false;
                    if(res.length() > 0)
                        last = res.charAt(res.length()-1);
                }
                res.append(ch);
                freq[ch-'a']--;
                inResult[ch-'a'] = true;
            }
        }
        return res.toString();
    }
}
