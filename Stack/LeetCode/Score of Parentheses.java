/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
*/

class Solution {
    public int scoreOfParentheses(String S) 
    {
        int level = -1,score = 0;
        boolean inFlag = false;
        
        for(char ch : S.toCharArray())
        {
            if(ch == '(')
            {
                level++;
                inFlag = true;
            }
            else
            {
                if(inFlag)
                {
                    score += Math.pow(2,level);
                    inFlag = false;
                }
                level--;
            }
        }
        return score;
    }
}
