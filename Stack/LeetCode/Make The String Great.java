/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
*/

class Solution {
    public String makeGood(String s) 
    {
        int n = s.length();
        if(n == 0 || n == 1)
            return s;
        StringBuffer res = new StringBuffer("");
        
        for(char ch : s.toCharArray())
        {
            if(res.length() == 0)
                res.append(ch);
            else
            {
                int ind = res.length()-1;
                if(Math.abs(ch-res.charAt(ind)) == 32)      //abs(e-E) = 32
                    res.delete(ind,ind+1);
                else
                    res.append(ch);
            }
        }
        return res.toString();
    }
    
}
