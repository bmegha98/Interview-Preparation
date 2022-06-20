/*
A valid encoding of an array of words is any reference string s and array of indices indices such that:

words.length == indices.length
The reference string s ends with the '#' character.
For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.

 

Example 1:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
Example 2:

Input: words = ["t"]
Output: 2
Explanation: A valid encoding would be s = "t#" and indices = [0].
 

Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 7
words[i] consists of only lowercase letters.
*/

//Discard words that are suffix of another word
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Arrays.sort(words,(a,b)->b.length()-a.length());
        int n = words.length;
        int[] aux = new int[n];
        for(int i=0;i<n;i++) {
            if(aux[i] == -1)
                continue;
            for(int j=i+1;j<n;j++) 
                if(words[i].endsWith(words[j])) {
                    aux[j] = -1;
                }
            aux[i] = -1;
            res += words[i].length()+1;
        }
        
        return res;
    }
}
