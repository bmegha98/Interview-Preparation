/*
Problem Description
Reverse the bits of an 32 bit unsigned integer A.
Problem Constraints
0 <= A <= 232
Input Format
First and only argument of input contains an integer A.
Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.
Example Input
Input 1:

 0
Input 2:

 3
Example Output
Output 1:

 0
Output 2:

 3221225472
Example Explanation
Explanation 1:

        00000000000000000000000000000000

=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000
*/

public class Solution {
    public long reverse(long a) {
        long res = 0;
        int i = 31;
        while(a > 0) {
            if((a & 1) == 1)
                res += Math.pow(2,i);
            a >>= 1;
            i--;
        }
        return res;
    }
}

//Using Divide And Conquer
public class Solution {
    public long reverse(long a) {
        /*
        Divide x (initially, 32) bits into two equal halves
            Right Shift first half to x/2 positions
            Left shift second half to x/2 positions
            for each half
                repeat
        */
        
        a = ((a & 0xffff0000) >>> 16) | ((a & 0x0000ffff) << 16);
        a = ((a & 0xff00ff00) >>> 8) | ((a & 0x00ff00ff) << 8);
        a = ((a & 0xf0f0f0f0) >>> 4) | ((a & 0x0f0f0f0f) << 4);
        a = ((a & 0xcccccccc) >>> 2) | ((a & 0x33333333) << 2);
        a = ((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1);
        
        return a;
    }
}
