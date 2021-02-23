/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
*/

//Creating StringBuffers

class Solution {
    
    public String buildString(String S)
    {
        StringBuffer newS = new StringBuffer("");
        for(char ch : S.toCharArray())
        {
            int len = newS.length();
            
            if(ch == '#')
            {
                if(len > 0)
                    newS.delete(len-1,len);
            }
            else
                newS.append(ch);
        }
        return newS.toString();
    }
    public boolean backspaceCompare(String S, String T) 
    {
        return buildString(S).equals(buildString(T));
    }
}

//Using Two pointers

class Solution {
    
    public boolean backspaceCompare(String S, String T) 
    {
        int i = S.length()-1,countInS = 0,j = T.length()-1,countInT = 0;
        while(true)
        {
            while(i >= 0)
            {
                if(S.charAt(i) == '#')
                {
                    countInS++;
                    i--;
                }
                else if(countInS > 0)
                {
                    countInS--;
                    i--;
                }
                else
                    break;
            }
            while(j >= 0)
            {
                if(T.charAt(j) == '#')
                {
                    countInT++;
                    j--;
                }
                else if(countInT > 0)
                {
                    countInT--;
                    j--;
                }
                else
                    break;
            }
            if(i >= 0 && j >= 0)
            {
                if(S.charAt(i) != T.charAt(j))
                    return false;
                i--;
                j--;
            }
            else
                break;
        }
        return i==j?true:false;
    }
}
