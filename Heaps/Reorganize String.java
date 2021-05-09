/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
*/

class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        if(n < 2)
            return S;
        if(n == 2)
            return S.charAt(0)==S.charAt(1)?"":S;
        int maxAllowed = n%2==0?n/2:(n/2 + 1);
        
        int[] freq = new int[26];
        for(int i =0;i<n;i++)
            freq[S.charAt(i)-'a']++;
        
        PriorityQueue<Character> aux = new PriorityQueue<>(1, (x,y)->freq[y-'a']-freq[x-'a']);
        
        for(int i = 0;i<26;i++) {
            if(freq[i] == 0)
                continue;
            if(freq[i] > maxAllowed)
                return "";
            char ch = (char)('a'+i);
            aux.add(ch);
        }
        
        StringBuilder res = new StringBuilder(S);
        int j = 0;
        while(!aux.isEmpty()) {
            char ch = aux.poll();
            while(freq[ch-'a']-- > 0) {
                if(j >= n)
                    j = 1;
                res.setCharAt(j, ch);
                j = j+2;
            }
        }
        return res.toString();
    }
        
//         int maxFreq = 0;
//         char maxFreqChar='a';
//         for(int i=0;i<n;i++) {
//             char ch = S.charAt(i);
//             freq[ch-'a']++;
//             if(freq[ch-'a']>maxFreq) {
//                 maxFreq = freq[ch-'a'];
//                 maxFreqChar = ch;
//             }
//         }
//         if(maxFreq > maxAllowed)
//             return "";
//         int i = 0;
//         StringBuilder res = new StringBuilder(S);
//         while(maxFreq-- > 0) {
//             res.setCharAt(i, maxFreqChar);
//             freq[maxFreqChar-'a']--;
//             i = i+2;
//         }
        
//         for(int j = 0;j<26;j++) {
//             char ch = (char)('a'+j);
//             while(freq[j]-- > 0) {
//                 if(i >= n)
//                     i = 1;
//                 res.setCharAt(i, ch);
//                 i = i+2;
//             }
//         }
//         return res.toString();
//     }
        
}
