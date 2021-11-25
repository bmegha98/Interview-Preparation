/*
Given a string str and another string patt. Find the first position (considering 0-based indexing) of the character in patt that is present at the minimum index in 
str.


Example 1:

Input:
str = geeksforgeeks
patt = set
Output: 1
Explanation: e is the character which is
present in given patt "geeksforgeeks"
and is first found in str "set". First Position
of e in str is 1. 
Example 2:

Input:
str = adcffaet
patt = onkl
Output: -1
Explanation: There are none of the
characters which is common in patt
and str.
*/

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        int[] indexArr = new int[26];
        int n = str.length();
        Arrays.fill(indexArr, n);
        for(int i=0;i<n;i++) {
            char ch = str.charAt(i);
            if(indexArr[ch-'a'] == n)
                indexArr[ch-'a'] = i;
        }
        
        int minIndex = n;
        for(char ch : patt.toCharArray()) 
            minIndex = Math.min(minIndex, indexArr[ch-'a']);
        return minIndex == n?-1 : minIndex;
    }
}
