//Given a string s, return the longest palindromic substring in s.
//using DP T(n) = O(n^2) , Space = O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        
        int maxLen = 1,start = 0;
        boolean[][] T = new boolean[n][n];
        char[] A = s.toCharArray();
        for(int i=0;i<n;i++){
            T[i][i] = true;
            if(i < n-1) {
                if(A[i] == A[i+1]) {
                    start = i;
                    maxLen = 2;
                    T[i][i+1] = true;
                }
                else
                    T[i][i+1] = false;
            } 
        }
        
        for(int j = 2;j<n;j++) {
            for(int i = j-2;i>=0;i--) {
                if(A[i] == A[j] && T[i+1][j-1]) {
                    if(maxLen < j-i+1) {
                        maxLen = j-i+1;
                        start = i;
                    }
                    T[i][j] = true;
                }
                else
                    T[i][j] = false;
            }
        }
        return s.substring(start,start+maxLen);
    }
}

//Using Window Expansion
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        int start = 0,maxlen = 1;
        for(int i = 1;i<n;i++) {
            //consider each character as center of palindrome
            //even length palindromes : two centers 
            int low = i-1,high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(maxlen < high-low+1) {
                    maxlen = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
            
            //odd length palindromes : one center
            low = i-1;
            high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(maxlen < high-low+1) {
                    maxlen = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,start+maxlen);
    }
}
