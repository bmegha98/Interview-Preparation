/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

class Solution {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> digits = new Stack<>();
        
        int i=0, n = s.length();
        while(i<n) {
            char ch = s.charAt(i);
            if(ch == ' ') 
                i++;
            else if(Character.isDigit(ch)) {
                String num = "";
                while(i < n && Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                digits.push(Integer.parseInt(num));
            }
            else {
                int p = getPriority(ch);
                if(operators.isEmpty() || p > getPriority(operators.peek()))
                    operators.push(ch);
                else {
                    while(!operators.isEmpty() && p <= getPriority(operators.peek())) 
                    {
                        char op = operators.pop();
                        int second = digits.pop(), first = digits.pop();
                        digits.push(eval(op,first,second));
                    }
                    operators.push(ch);
                }
                i++;
            }
        }
        while(!operators.isEmpty()) {
            char op = operators.pop();
            int second = digits.pop(), first = digits.pop();
            digits.push(eval(op,first,second));
        }
        
        return digits.pop();
    }
    
    private int getPriority(char op) {
        if(op == '*' || op == '/')
            return 2;
        if(op == '+' || op == '-')
            return 1;
        return 0;
    }
    
    private int eval(char op, int a, int b) {
        if(op == '+')
            return a+b;
        if(op == '-')
            return a-b;
        if(op == '*')
            return a*b;
        return a/b;
    }
}
