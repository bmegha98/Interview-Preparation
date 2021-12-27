/*
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts 
needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and
returns minimum number of partitions required.
*/

class Solution{
    static int[][] T;
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        if(n == 1)
            return 0;
        if(isPalindrome(str,0,n-1))
            return 0;
        T = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(T[i],-1);
        return helper(str,0,n-1);
    }
    static int helper(String s, int i, int j) {
        if(i >= j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        if(T[i][j] != -1)
            return T[i][j];
        int maxCuts = j-i+1;
        for(int k = i;k<j;k++) {
            int left = -1,right = -1;
            if(T[i][k] != -1)
                left = T[i][k];
            else {
                left = helper(s,i,k);
                T[i][k] = left;
            }
            if(T[k+1][j] != -1)
                right = T[k+1][j];
            else {
                right = helper(s,k+1,j);
                T[k+1][j] = right;
            }
            maxCuts = Math.min(maxCuts, left+right+1);
        }
        T[i][j] = maxCuts;
        return maxCuts;
    }
    static boolean isPalindrome(String s, int l, int h) {
        while(l<h) {
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        
        return true;
    }
}
