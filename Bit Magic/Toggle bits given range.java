/*
Given a non-negative number N and two values L and R. The problem is to toggle the bits in the range L to R in the binary representation of N, i.e, to toggle bits
from the rightmost Lth bit to the rightmost Rth bit. A toggle operation flips a bit 0 to 1 and a bit 1 to 0. Print N after the bits are toggled.
Example 1:

Input:
N = 17 , L = 2 , R = 3
Output:
23
Explanation:
(17)10 = (10001)2.  After toggling all
the bits from 2nd to 3rd position we get
(10111)2 = (23)10
Example 2:

Input:
N = 50 , L = 2 , R = 5
Output:
44
Explanation:
(50)10 = (110010)2.  After toggling all
the bits from 2nd to 3rd position we get
(101100)2 = (44)10
*/

class Solution {
    static int toggleBits(int N , int L , int R) {
        // code here
        L--;
        R--;
        int res = 0;
        for(int i=0;i<32;i++) {
            if(i >= L && i <= R)
                N ^= (1 << i);
        }
        
        return N;
    }
}
