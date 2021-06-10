/*
Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a 
balanced expression.A reversal means changing '{' to '}' or vice-versa.
Example 1:

Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.
Example 2:

Input: 
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.
*/

class Sol
{
    int countRev (String s)
    {
        int n = s.length();
        if(n % 2 == 1)
            return -1;
        int count = 0,ans = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '{')
                count++;
            else {
                if(count == 0) {
                    //No opening brace before it i.e. unbalanced so, reverse it
                    ans++;
                    count++;
                }
                else
                    count--;
            }
        }
        //count = no. of { so reverse half of them
        return ans+(count/2);
    }
}
