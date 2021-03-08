/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a 
positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be
input like 3a or 2[4].
*/

class Solution {
    public String decodeString(String s) 
    {
        if(s.length() == 0)
            return s;
        Stack<Character> aux = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch == ']')
            {
                String rep = "";
                while(!aux.isEmpty() && aux.peek() != '[')
                    rep = aux.pop()+rep;
                aux.pop();
                String freq = "";
                while(!aux.isEmpty() && Character.isDigit(aux.peek()))
                    freq = aux.pop()+freq;
                int times = Integer.parseInt(freq);
                
                while(times-- > 0)
                {
                    for(int i=0;i<rep.length();i++)
                        aux.push(rep.charAt(i));
                }
            }
            else
                aux.push(ch);
        }
        
        String res = "";
        while(!aux.isEmpty())
            res = aux.pop()+res;
        return res;
    }
}

//Another Approach - Using two stacks

class Solution {
    public String decodeString(String s) 
    {
        int n = s.length();
        if(n == 0)
            return s;
        Stack<String> aux = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String curr = "";
     
        for(int i =0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch == ']')
            {
                String rep = "";
                String toBeAdded = aux.pop();
                int times = intStack.pop();
                while(times-- > 0)
                    toBeAdded += curr;
              
                curr = toBeAdded;
            }
            else if(Character.isDigit(ch))
            {
                String freq = "";
                while(i < n && Character.isDigit(s.charAt(i)))
                {
                    freq += s.charAt(i);
                    i++;
                }
                i--;
                
                intStack.push(Integer.parseInt(freq));
            }
            else if(ch == '[')
            {
                aux.push(curr);
                curr = "";
            } 
            else
                curr += ch;
        }
        
        return curr;
    }
}
