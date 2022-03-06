/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by
zero operation.
Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> aux = new Stack<>();
        
        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int second = aux.pop(), first = aux.pop();
                aux.push(evaluate(s.charAt(0),first,second));
            }
            else
                aux.push(Integer.parseInt(s));
        }
        return aux.pop();
    }
    
    private int evaluate(char op, int f, int s) {
        if(op == '+')
            return f+s;
        if(op == '-')
            return f-s;
        if(op == '*')
            return f*s;
        return f/s;
    }
}
