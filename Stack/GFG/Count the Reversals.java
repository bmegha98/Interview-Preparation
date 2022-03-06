/*
Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a 
balanced expression.
A reversal means changing '{' to '}' or vice-versa.

Example 1:

Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.
â€‹Example 2:

Input: 
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countRev() which takes the string S as input parameter and returns the 
minimum number of reversals required to balance the bracket sequence. If balancing is not possible, return -1. 
*/

//Using Stack

class Sol
{
    int countRev (String s) {
        // your code here 
        int n = s.length();
        if(n%2 == 1)
            return -1;
        int res = 0;
        Stack<Character> aux = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '{')
                aux.push(ch);
            else {
                if(aux.isEmpty()) {
                    res++;
                    aux.push('{');
                }
                else 
                    aux.pop();
            }
        }
        
        int len = aux.size();
        if(len%2 == 1)
            return -1;
        return res+len/2;
    }
}

//Space Optimization

class Sol
{
    int countRev (String s) {
        // your code here 
        int n = s.length();
        if(n%2 == 1)
            return -1;
        int res = 0,op = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == '{')
                op++;
            else {
                if(op == 0) {
                    res++;
                    op++;
                }
                else 
                    op--;
            }
        }
        
        return op%2 == 1 ? -1 : res + op/2;
    }
}
