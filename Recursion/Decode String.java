/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a
positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not 
be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/

class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> freq = new Stack<>();
        Stack<String> aux = new Stack<>();
        String curr = "";
        int i=0;
        while(i<n) {
            char ch = s.charAt(i);
            if(ch == '[') {
                aux.add(curr);
                curr = "";
                i++;
            }
            else if(Character.isLetter(ch)) {
                curr += ch;
                i++;
            }
            else if(Character.isDigit(ch)) {
                String times = "";
                while(i<n && Character.isDigit(s.charAt(i))) {
                    times += s.charAt(i);
                    i++;
                }
                freq.push(Integer.parseInt(times));
            }
            else {
                int f = freq.pop();
                String tmp = new String(curr);
                while(f-- > 1)
                    curr += tmp;
                String top = aux.pop();
                curr = top+curr;
                i++;
            }
        }
        return curr;
    }
}
