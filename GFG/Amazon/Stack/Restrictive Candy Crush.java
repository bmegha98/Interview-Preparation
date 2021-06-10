/*
Given a string s and an integer k, the task is to reduce the string by applying the following operation:
Choose a group of k consecutive identical characters and remove them.

The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
k = 2
s = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geeksforgeeks" -> "gksforgks"
*/

class Pair{
    char ch;
    int freq;
    public Pair(char c, int f) {
        ch = c;
        freq = f;
    }
    public char getKey() {
        return ch;
    }
    public int getValue() {
        return freq;
    }
    public void setValue(int val) {
        freq = val;
    }
}
class Solution
{
    public static String reduced_String(int k, String s)
    {
        if(k == 1)
            return "";
        Stack<Pair> aux = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(aux.isEmpty() || aux.peek().getKey() != ch)
                aux.push(new Pair(ch,1));
            else 
                aux.peek().setValue(aux.peek().getValue()+1);
            if(aux.peek().getValue() == k)
                aux.pop();
        }
        
        StringBuilder res = new StringBuilder("");
        while(!aux.isEmpty()) {
            Pair p = aux.pop();
            for(int i=0;i<p.getValue();i++)
                res.append(p.getKey());
        }
        return res.reverse().toString();
    }
}
