/*
Given a String. Reverse each word in it where the words are separated by dots.

Example 1:

Input:
S = "i.like.this.program.very.much"
Output: 
i.ekil.siht.margorp.yrev.hcum
Explanation: 
The words are reversed as
follows:"i" -> "i","like"->"ekil",
"this"->"siht","program" -> "margorp",
"very" -> "yrev","much" -> "hcum".
Example 2:

Input: 
S = "pqr.mno"
Output: 
rqp.onm
Explanation: 
The words are reversed as
follows:"pqr" -> "rqp" ,
"mno" -> "onm"

Your Task:
You don't need to read input or print anything. Your task is to complete the functionreverseWords()which takes the string S as input and returns the resultant 
string by reversing all the words separated by dots.
*/

class Solution
{
    String reverseWords(String S)
    {
        // your code here
        StringBuilder res = new StringBuilder("");
        StringBuilder tmp = new StringBuilder("");
        for(char ch : S.toCharArray()) {
            if (ch == '.') {
                res.append(tmp.toString());
                res.append(ch);
                tmp.setLength(0);
            }
            else {
                if(tmp.length() == 0)
                    tmp.append(ch);
                else
                    tmp.insert(0,ch);
            }
        }
        
        res.append(tmp.toString());
        return res.toString();
    }
}
