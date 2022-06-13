/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

//Brute-force, T(n) = O(n^2), Space = O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> aux = new HashSet<>();
        int maxLen = 0, n = s.length();
        
        int i=0;
        while(i < n) {
            aux.add(s.charAt(i));
            int j=i+1;
            while(j<n && !aux.contains(s.charAt(j))) {
                aux.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
            i++;
            aux.clear();
        }
        
        return maxLen;
    }
}

//Optimized
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> aux = new HashSet<>();
        int maxLen = 0, n = s.length();
        
        int left=0, right=0;
        while(right < n) {
            if(!aux.contains(s.charAt(right))) {
                aux.add(s.charAt(right));
                right++;
                maxLen = Math.max(maxLen,right-left);
            }
            else {
                while(left < right && aux.contains(s.charAt(right))) {
                    aux.remove(s.charAt(left));
                    left++;
                }
            }
        }
        
        return maxLen;
    }
}
