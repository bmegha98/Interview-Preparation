/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence 
of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1
*/

/*          length
0             1
01            2
0110          4
01101001      8

first half of nth row == n-1th row
second half of nth row == compliment of (n-1)th row
*/

//MLE T(n) = Space = O(2^n)
class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1)
            return 0;
        String res = helper(n);
        return res.charAt(k-1)-'0';
    }
    
    private String helper(int n) {
        if(n == 1)
            return "0";
        String s = helper(n-1);
        StringBuilder tmp = new StringBuilder(s);
        for(char ch : s.toCharArray()) {
            if(ch == '0')
                tmp.append("1");
            else
                tmp.append("0");
        }
        return tmp.toString();
    }
}


//Optimized

/*
Solve(n,k) = kth symbol in nth row 
if k is in first half then solve(n,k) = solve(n-1,k)
else kth symbol in second half of nth row is mapped to the complement of (k-mid)th symbol of (n-1)th row.
*/

class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1)
            return 0;
        int mid = 1<<(n-2);
        if(k <= mid)
            return kthGrammar(n-1,k);
        return 1 - kthGrammar(n-1, k-mid);
    }
}
