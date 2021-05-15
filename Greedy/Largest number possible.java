/*
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.

Example 1:

Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number 
with sum of digits equals to 9.
Example 2:

Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number 
with sum of digits equals to 20.
*/

class Solution{
    static String findLargest(int N, int S){
        String res = "";
        if(N == 1)
        {
            if(S > 9)
                res += "-1";
            else
                res += ((char)(S+'0'));
            return res;
        }
        if(N > 1 && S == 0)
            return new String("-1");
        
        for(int i =0;i<N;i++) {
            int j = 9;
            while(j > S)
                j--;
            S -= j;
            res += (char)(j+'0');
        }
        
        if(S > 0)
            return new String("-1");
        return res;
    }
}
