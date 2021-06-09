/*
Given a String. Reverse each word in it where the words are separated by dots.
Example 1:

Input:
S = "i.like.this.program.very.much"
Output: i.ekil.siht.margorp.yrev.hcum
Explanation: The words "i", "like","this", "program", "very", "much" are all reversed.
*/

class Solution
{
   
    String reverseWords(String S)
    {
        int n = S.length();
        if(n == 1)
            return S;
        Stack<Character> aux = new Stack<>();
        
        StringBuilder res = new StringBuilder("");
        int i = 0;
        while(i < n) {
            if(S.charAt(i) == '.') {
                res.append('.');
                i++;
            }
            else {
                while(i < n && S.charAt(i) != '.') {
                    aux.push(S.charAt(i));
                    i++;
                }
                
                while(!aux.isEmpty())
                    res.append(aux.pop());
            }
        }
        while(!aux.isEmpty())
            res.append(aux.pop());
        return res.toString();
    }
}
