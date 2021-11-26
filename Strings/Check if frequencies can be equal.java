/*
Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that 
frequency of each distinct character becomes same in the string.

Example 1:

Input:
s = xyyz
Output: 1 
Explanation: Removing one 'y' will make 
frequency of each letter 1.

Example 2:

Input:
s = xxxxyyzz
Output: 0
Explanation: Frequency can not be made same 
same by removing just 1 character.
*/

class Solution {
    boolean sameFreq(String s) {
        // code here
        int n = s.length();
        
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        
        int x = -1, y = -1;
        for(int i=0;i<26;i++) {
            if(freq[i] == 0)
                continue;
            if(x == -1)
                x = freq[i];
            else if(freq[i] != x && y == -1)
                y = freq[i];
            else if(freq[i] != x && freq[i] != y)
                return false;
        }
        
        if(x == -1 || y == -1)
            return true;
        return Math.abs(x-y) < 2 || x == 1 || y == 1;
    }
}
