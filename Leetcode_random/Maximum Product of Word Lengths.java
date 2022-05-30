/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two
words exist, return 0.

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
*/

//Brute-force, Time = O(n*n*m) 
class Solution {
    public int maxProduct(String[] words) {
        int res = 0, n = words.length;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) {
                int len1 = words[i].length(), len2 = words[j].length();
                if(noCommonElements(words[i], words[j]))
                    res = Math.max(res, len1*len2);
            }
        return res;
    }
    
    private boolean noCommonElements(String w1, String w2) {
        Set<Character> aux = new HashSet<>();
        for(char ch : w1.toCharArray())
            aux.add(ch);
        
        for(char ch : w2.toCharArray())
            if(aux.contains(ch))
                return false;
        return true;
    }
}

//Optimized, Time = O(m*n + n*n*26) 
class Solution {
    public int maxProduct(String[] words) {
        int res = 0, n = words.length;
        int[][] T = new int[n][26];
        
        for(int i=0;i<n;i++) {
            String s = words[i];
            for(char ch : s.toCharArray())
                T[i][ch-'a'] = 1;
        }
        
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int len1 = words[i].length(), len2 = words[j].length();
                if(noCommonElements(T[i], T[j]))
                    res = Math.max(res, len1*len2);
            }
        }
        return res;
    }
    
    private boolean noCommonElements(int[] w1, int[] w2) {
        for(int i=0;i<26;i++)
            if(w1[i] == 1 && w2[i] == 1)
                return false;
        return true;
    }
}
