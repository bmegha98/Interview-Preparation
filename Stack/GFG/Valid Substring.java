/*
Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of the smallest valid substring ( ) is 2.

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

Your Task:  
You dont need to read input or print anything. Complete the function findMaxLen() which takes S as input parameter and returns the maxlength.
*/
//T(n) = Space = O(n)
class Solution {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> aux = new Stack<>();
        aux.push(-1);
        int res = 0;
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == '(')
                aux.push(i);
            else {
                aux.pop();
                if(aux.isEmpty())
                    aux.push(i);
                else
                    res = Math.max(res,i-aux.peek());
            }
        }
        return res;
    }
}

//SPACE OPTIMIZATION

class Solution {
    static int findMaxLen(String S) {
        // code here
        int n = S.length();
        if(n<2)
            return 0;
        
        int left = 0, right = 0, res = 0;
        for(int i=0;i<n;i++) {
            char ch = S.charAt(i);
            if(ch == '(')
                left++;
            else
                right++;
            if(left == right)
                res = Math.max(res,left+right);
            else if(left < right) {
                left = 0;
                right = 0;
            }
        }
        left = 0; right = 0;
        for(int i=n-1;i>=0;i--) {
            char ch = S.charAt(i);
            if(ch == '(')
                left++;
            else
                right++;
            if(left == right)
                res = Math.max(res,left+right);
            else if(left > right) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }
}
