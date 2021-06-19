/*
Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
*/

class Solution {

    int search(String t, String s) {
        //System.out.println(s+":"+t);
        int m = s.length(),n = t.length();
        if(n > m)
            return 0;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        
        for(char ch : t.toCharArray())
            freqT[ch-'a']++;
        
        int ans = 0,l = 0,r = 0,count = 0;
        while(r < n) {
            freqS[s.charAt(r)-'a']++;
            r++;
        }
        
        while(r < m) {
            if(isEqual(freqS,freqT))
                ans++;
            freqS[s.charAt(l)-'a']--;
            l++;
            freqS[s.charAt(r)-'a']++;
            r++;
        }
        if(isEqual(freqS,freqT))
            ans++;
        return ans;
    }
    private boolean isEqual(int[] freqS,int[] freqT) {
        for(int i=0;i<26;i++)
            if(freqS[i] != freqT[i])
                return false;
        return true;
    }
}

//Another method
class Solution {

    int search(String t, String s) {
        //System.out.println(s+":"+t);
        int m = s.length(),n = t.length();
        if(n > m)
            return 0;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        
        for(char ch : t.toCharArray())
            freqT[ch-'a']++;
        
        int ans = 0,l = 0,r = 0,count = 0;
        
        while(r < m) {
            int ind = s.charAt(r)-'a';
            freqS[ind]++;
            if(freqT[ind] > 0 && freqS[ind] <= freqT[ind])
                count++;
            if(count == n) {
                while(freqT[s.charAt(l)-'a'] == 0 || 
                    freqS[s.charAt(l)-'a'] > freqT[s.charAt(l)-'a']) {
                    freqS[s.charAt(l)-'a']--;
                    l++;
                }
                if(r-l+1 == n)
                    ans++;
            }
            r++;
        }
        
        return ans;
    }
}
