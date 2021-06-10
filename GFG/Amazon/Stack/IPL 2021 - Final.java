/*
IPL 2021 Finals are here and it is between the most successful team of the IPL Mumbai Indians and the team striving to garb their first trophy Royal Challengers 
Banglore. Rohit Sharma, captain of the team Mumbai Indians has the most experience in IPL finals, he feels lucky if he solves a programming question before the 
IPL finals. So, he asked the team's head coach  Mahela Jayawardene for a question. Question is, given a string S consisting only of opening and closing parenthesis
'ie '('  and ')',  the task is to find out the length of the longest valid parentheses substring.

NOTE: The length of the smallest valid substring ( ) is 2.

Example 1:

Input: S = "(()("
Output: 2
Explanation: The longest valid 
substring is "()". Length = 2.
Example 2:

Input: S = "()(())("
Output: 6
Explanation: The longest valid 
substring is "()(())". Length = 6.
*/

class Solution {
    static int findMaxLen(String S) {
        int n = S.length();
        if(n == 1)
            return 0;
        int left = 0,right =0,maxLen = 0;
        
        for(int i=0;i<n;i++) {
            if(S.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLen = Math.max(maxLen,left+right);
            else if(right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(int i=n-1;i>=0;i--) {
            if(S.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLen = Math.max(maxLen,left+right);
            else if(right < left){
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
