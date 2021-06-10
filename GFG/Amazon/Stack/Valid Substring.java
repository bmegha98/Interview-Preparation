/*
Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of smallest the valid substring ( ) is 2.

Example 1:

Input: S = "(()("
Output: 2
Explanation: The longest valid 
substring is "()". Length = 2.
Example 2:

Input: S = "()(())("
Output: 6
Explanation: The longest valid 
substring is "()(())". Length = 6.
*/

//Using Stack
class Solution {
    static int findMaxLen(String S) {
        int n = S.length();
        if(n == 1)
            return 0;
        Stack<Integer> aux = new Stack<>();
        int maxLen = 0;
        aux.push(-1);
        for(int i=0;i<n;i++) {
            if(S.charAt(i) == '(')
                aux.push(i);
            else {
                aux.pop();
                if(aux.isEmpty())
                    aux.push(i);
                else
                    maxLen = Math.max(maxLen,i-aux.peek());
            }
        }
        return maxLen;
    }
}

//Using two pointers s = "(()"
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 1)
            return 0;
        int left = 0,right = 0;
        int maxLen = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLen = Math.max(maxLen,left+right);
            else if(right > left) {
                left = 0;
                right = 0;
            }
            
        }
        
        left = 0;
        right = 0;
        for(int i=n-1;i>=0;i--) {
            char ch = s.charAt(i);
            if(ch == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLen = Math.max(maxLen,left+right);
            else if(left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
