/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at 
most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and 
returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10
*/

class Solution
{
    static String max;
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k){
        //code here.
        max = str;
        helper(str,0,str.length(),k);
        return max;
    }
    
    private static void helper(String s, int ind, int n, int k) {
        if(s.compareTo(max) > 0)
            max = s;
        if(k == 0)
            return;
        
        for(int i=ind;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(s.charAt(i) < s.charAt(j)) {
                    s = swap(s,i,j);
                    helper(s,i+1,n,k-1);
                    s = swap(s,i,j);
                }
    }
    
    private static String swap(String s, int i, int j) {
        char[] A = s.toCharArray();
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        return new String(A);
    }
}