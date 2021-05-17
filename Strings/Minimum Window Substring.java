/*
Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in
s that covers all characters in t, return the empty string "".
Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
*/

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n)
            return "";
        int[] freqT = new int[256];
        int[] freqS = new int[256];
        for(char ch : t.toCharArray())
            freqT[ch]++;
        int minLen = Integer.MAX_VALUE,startIndex = -1;
        int left =0,right = 0,count = 0;
        while(right < m) {
            int ind = (int)s.charAt(right);
            right++;
            freqS[ind]++;
            
            if(freqT[ind] > 0 && freqS[ind] <= freqT[ind])
                count++;
            
            if(count == n) {
                int pos = s.charAt(left);
                while(left < right && (freqT[pos] == 0 || freqS[pos] > freqT[pos]))
                {
                    left++;
                    if(freqS[pos] > freqT[pos])
                        freqS[pos]--;
                    pos = (int)s.charAt(left);
                }
                if(right-left < minLen) {
                    minLen = right-left;
                    startIndex = left;
                }
                System.out.println(minLen);
            }
            
        }
        
        return startIndex == -1?"":s.substring(startIndex,startIndex+minLen);
    }
}
