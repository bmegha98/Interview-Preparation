/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). 
For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.
Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Example 4:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/

//Recursion + Memoization T(n) = Space = O(n)
class Solution {
    int[] T;
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1)
            return s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
        if(s.charAt(0) == '0')
            return 0;
        T = new int[n+1];
        Arrays.fill(T,-1);
        return helper(s,n);
    }
    
    private int helper(String s, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
        if(T[n] != -1)
            return T[n];
        String group1 = s.substring(n-1,n);
        int count = 0;
        if(group1.charAt(0) >= '1' && group1.charAt(0) <= '9')
            count += helper(s,n-1);
        String group2 = s.substring(n-2,n);
        Integer num = Integer.parseInt(group2);
        if(group2.charAt(0) >= '1' && num < 27)
            count += helper(s,n-2);
        
        return T[n]=count;
    }
}

//Tabulation T(n) = O(n) , Space = O(n)
class Solution {
    int[] T;
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1)
            return s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
        if(s.charAt(0) == '0')
            return 0;
        T = new int[n+1];
    
        T[0] = 1;
        T[1] = 1;
        
        for(int i=2;i<=n;i++) {
            int x = Integer.valueOf(s.substring(i-1,i));
            if(x > 0 && x <= 9)
                T[i] += T[i-1];
            
            Integer y = Integer.valueOf(s.substring(i-2,i));
            if(y >= 10 && y < 27)
                T[i] += T[i-2];
        }
        return T[n];
    }
}

//Constant Space
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1)
            return s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
        if(s.charAt(0) == '0')
            return 0;
    
        int secondLast = 1, last = 1;
        
        for(int i=2;i<=n;i++) {
            int x = Integer.valueOf(s.substring(i-1,i));
            int tmp = 0;
            if(x > 0 && x <= 9)
                tmp += last;
            
            Integer y = Integer.valueOf(s.substring(i-2,i));
            if(y >= 10 && y < 27)
                tmp += secondLast;
            secondLast = last;
            last = tmp;
        }
        
        return last;
    }
    
}
