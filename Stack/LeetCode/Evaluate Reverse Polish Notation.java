/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by 
zero operation.
*/

class Solution {
    private int evaluate(char op, int a, int b) {
        if(op == '+')
            return a+b;
        if(op == '-')
            return a-b;
        if(op == '*')
            return a*b;
        return a/b;
    }
    
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n == 1)
            return Integer.valueOf(tokens[0]);
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> aux = new Stack<>();
        for(String str : tokens) {
            final String lambdaVar = str;
            boolean neg = false;
            if(operators.stream().anyMatch(t->t.equals(lambdaVar)))
            {
                int first = aux.pop();
                int second = aux.pop();
                int res = evaluate(str.charAt(0), second, first);
                aux.push(res);
            }
            else 
            {
                if(str.charAt(0) == '-') {
                    neg = true;
                    str = str.substring(1);
                }
                int num = Integer.valueOf(str);
                if(neg)
                    num *= -1;
                aux.push(num);
            }
        }
        return aux.pop();
    }
}
