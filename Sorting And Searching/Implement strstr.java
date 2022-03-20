/*
Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string
s. The function returns and integer denoting the first occurrence of the string x in s (0 based indexing).

Note: You are not allowed to use inbuilt function.
Example 1:

Input:
s = GeeksForGeeks, x = Fr
Output: -1
Explanation: Fr is not present in the
string GeeksForGeeks as substring.
 

Example 2:

Input:
s = GeeksForGeeks, x = For
Output: 5
Explanation: For is present as substring
in GeeksForGeeks from index 5 (0 based
indexing).
 

Your Task:
You don't have to take any input. Just complete the strstr() function which takes two strings str, target as an input parameter. The function returns -1
if no match if found else it returns an integer denoting the first occurrence of the x in the string s.
*/

class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x) {
        // Your code here
        int n = s.length(), m = x.length();
        if(m > n)
            return -1;
        
        for(int i=0;i<=n-m;i++) {
            boolean found = true;
            for(int j=0;j<m;j++)
                if(x.charAt(j) != s.charAt(i+j)) {
                    found = false;
                    break;
                }
            if(found)
                return i;
        }
        return -1;
    }
}
