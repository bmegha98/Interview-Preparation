/*
Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.
*/

class Solution {
    public boolean isValid(String s) 
    {
        int n = s.length();
        if(n == 0)
            return true;
        if(n < 3)
            return false;
        Stack<Character> aux = new Stack<>();
        
        for(char ch : s.toCharArray())
        {
            if(ch == 'a')
                aux.push(ch);
            else if(ch == 'b')
            {
                if(aux.isEmpty()||aux.peek() != 'a')
                    return false;
                aux.push(ch);
            }
            else
            {
                if(aux.isEmpty()||aux.peek() != 'b')
                    return false;
                 while(!aux.isEmpty() && aux.peek() != 'a')
                     aux.pop();
                aux.pop();
            }
        }
        return aux.isEmpty();
    }
}
