/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/

//Using Stack, T(n) = Space = O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n < 2)
            return 0;
        Stack<Integer> aux = new Stack<>();
        int res = 0;
        aux.push(-1);
        
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '(')
                aux.push(i);
            else {
                aux.pop();
                if(aux.isEmpty())
                    aux.push(i);
                else
                    res = Math.max(res, i-aux.peek());
            }
        }
        return res;
    }
}

//Space optimization
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n < 2)
            return 0;
        int res = 0,open = 0, close = 0;
        
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '(')
                open++;
            else
                close++;
            
            if(close > open) {
                open = 0;
                close = 0;
            }
            else if(close == open)
                res = Math.max(res, open+close);
        }
        
        open = 0;
        close = 0;
        for(int i=n-1;i>=0;i--) {
            if(s.charAt(i) == '(')
                open++;
            else
                close++;
            
            if(close < open) {
                open = 0;
                close = 0;
            }
            else if(open == close)
                res = Math.max(res, open+close);
        }
        
        return res;
    }
}
