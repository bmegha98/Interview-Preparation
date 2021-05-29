/*
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts
needed for palindrome partitioning of given string.
Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
*/

//Multiway choice : min{minCounts(1,k)+minCounts(k+1,n)+1 , for each k = 1,2,...,n-1}
//T(n) : O(n^2) , Space = O(n^2)
class Solution{
    static int[][] T;
    static int palindromicPartition(String str)
    {
        int n = str.length();
        if(n == 1)
            return 0;
        if(n == 2)
            return str.charAt(0)==str.charAt(1)?0:1;
        char[] S = str.toCharArray();
        T = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(T[i],-1);
        return minCuts(S,0,n-1);
    }
    private static int minCuts(char[] A,int i,int j) {
        if(i >= j)
            return 0;
        if(isPalindrome(A,i,j))
            return 0;
        if(T[i][j] != -1)
            return T[i][j];
        int tmp = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++)
            tmp = Math.min(tmp, minCuts(A,i,k)+minCuts(A,k+1,j)+1);
        return T[i][j]=tmp;
    }
    private static boolean isPalindrome(char[] S,int start,int end) {
        while(start < end) {
            if(S[start] != S[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}

//Further Optimization
class Solution{
    static int[][] T;
    static int palindromicPartition(String str)
    {
        int n = str.length();
        if(n == 1)
            return 0;
        if(n == 2)
            return str.charAt(0)==str.charAt(1)?0:1;
        char[] S = str.toCharArray();
        if(isPalindrome(S,0,n-1))
            return 0;
        T = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(T[i],-1);
        return minCuts(S,0,n-1);
    }
    private static int minCuts(char[] A,int i,int j) {
        if(i >= j)
            return 0;
        if(isPalindrome(A,i,j))
            return 0;
        if(T[i][j] != -1)
            return T[i][j];
        int tmp = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++) {
            int left = -1,right = -1;
            if(T[i][k] != -1)
                left = T[i][k];
            else {
                left = minCuts(A,i,k);
                T[i][k] = left;
            }
            if(T[k+1][j] != -1)
                right = T[k+1][j];
            else {
                right = minCuts(A,k+1,j);
                T[k+1][j] = right;
            }
            tmp = Math.min(tmp, left + right + 1);
        }
        return T[i][j]=tmp;
    }
    private static boolean isPalindrome(char[] S,int start,int end) {
        while(start < end) {
            if(S[start] != S[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
