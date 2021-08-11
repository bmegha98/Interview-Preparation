/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
Given an encoded message A containing digits, determine the total number of ways to decode it modulo 109 + 7.
Problem Constraints
1 <= |A| <= 105

Input Format
The first and the only argument is a string A.

Output Format
Return a single integer denoting the total number of ways to decode it modulo 109 + 7.

Example Input
Input 1:

 A = "8"
Input 2:

 A = "12"


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
*/

//Recursion+Memoization
public class Solution {
    int MOD=1000000007;
    int[] T;
    public int numDecodings(String A) {
        int n = A.length();
        if(A.charAt(0) == '0')
            return 0;
        T = new int[n+1];
        Arrays.fill(T,-1);
        return countWays(A.toCharArray(),n);
    }
    
    private int countWays(char[] A, int n) {
        if(n == 0)
            return 1;
        if(A[0] == '0')
            return 0;
        if(n == 1)
            return 1;
        if(T[n] != -1)
            return T[n];
        char last = A[n-1];
        char secondLast = A[n-2];
        
        int count = 0;
        if(last > '0') 
            count = countWays(A,n-1)%MOD;
        
        if(secondLast == '0')
            return T[n]=count;
        String tmp = ""+secondLast+last;
        if(Integer.valueOf(tmp) >= 10 && Integer.valueOf(tmp) <= 26)
            count = (count+countWays(A,n-2))%MOD;
        return T[n]= count;
    }
}

//Tabulation
public class Solution {
    int MOD=1000000007;
    int[] T;
    public int numDecodings(String A) {
        int n = A.length();
        if(A.charAt(0) == '0')
            return 0;
        T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        
        for(int i=2;i<=n;i++) {
            char last = A.charAt(i-1);
            String secondLast = A.substring(i-2,i);
            int count = 0;
            if(last > '0')
                count = T[i-1]%MOD;
            int num = Integer.valueOf(secondLast);
            if(num >= 10 && num <= 26)
                count = (count+T[i-2])%MOD;
            T[i] = count;
        }
        return T[n];
    }
    
}

//Constant Space, T(n) = O(n), Space = O(1)
public class Solution {
    int MOD=1000000007;
    public int numDecodings(String A) {
        int n = A.length();
        if(A.charAt(0) == '0')
            return 0;
        int last = 1, secondLast = 1;
        
        for(int i=2;i<=n;i++) {
            char oneChar = A.charAt(i-1);
            String twoChar = A.substring(i-2,i);
            int count = 0;
            if(oneChar > '0')
                count = last%MOD;
            int num = Integer.valueOf(twoChar);
            if(num >= 10 && num <= 26)
                count = (count+secondLast)%MOD;
            
            secondLast = last;
            last = count;
        }
        return last;
    }
    
}
