/*
Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. 
If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
*/

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int maxLen = 0;
        String res = "";
        for(String str : dictionary) {
            int n = str.length();
            if(isSubsequence(str, s) && maxLen <= n) {
                if(maxLen < n) {
                    maxLen = n;
                    res = str;
                }
                else if(str.compareTo(res) < 0)
                    res = str;
            }
        }
        return res;
    }
    private boolean isSubsequence(String s, String t) {
        int i=0,j = 0,m = s.length(),n = t.length();
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        if(i == m)
            return true;
        return false;
    }
}
