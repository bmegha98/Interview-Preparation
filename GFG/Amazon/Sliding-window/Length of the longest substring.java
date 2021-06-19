/*
Given a string S, find the length of the longest substring without repeating characters.
Example 1:

Input:
S = "geeksforgeeks"
Output:
7
Explanation:
Longest substring is "eksforg".
Example 2:

Input:
S = "abdefgabef"
Output:
6
Explanation:
Longest substring are "abdefg" , "bdefga" and "defgab".
*/

class Solution{
    int longestUniqueSubsttr(String s){
        int n = s.length();
        if(n == 1)
            return 1;
        int[] freq = new int[26];
        int i =0,j=0,len = 0;
        while(j<n) {
            while(j < n && freq[s.charAt(j)-'a'] == 0) {
                freq[s.charAt(j)-'a']++;
                j++;
            }
            len = Math.max(len,j-i);
            freq[s.charAt(i)-'a']--;
            i++;
        }
        len = Math.max(len,j-i);
        return len;
    }
}
