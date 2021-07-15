/*Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 
*/

public class Solution {
    public String convertToTitle(int A) {
        
        String res = "";
        while(A > 0) {
            int rem = A%26;
            A /= 26;
            if(rem == 0) {
                res = 'Z'+res;        //A = 52 then ans will be BZ which is wrong It should be AZ. So decrease A by 1.
                A--;
            }
            else
                res = (char)(rem-1+'A')+res;
        }
        return res;
    }
}
