/*
Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
Example 1:

Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates 
to true in 4 ways ((T|T)&(F^T)), 
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: N = 5
S = T^F|F
Output: 2
Explaination: ((T^F)|F) and (T^(F|F)) are the 
only ways.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes N and S as input parameters and returns number of
possible ways modulo 1003.
*/

class Solution{
    static int MOD = 1003;
    static Map<String,Integer> aux;
    static int countWays(int n, String S){
        // code here
        if(n == 1)
            return S.charAt(0) == 'T'?1:0;
        aux = new HashMap<>();
        return helper(S,true,0,n-1);
    }
    
    static private int helper(String s, boolean flag, int i, int j) {
        if(i > j)
            return 0;
        if(i == j){
            if(flag)
                return s.charAt(i) == 'T'?1:0;
            return s.charAt(i) == 'F'?1 : 0;
        }
        String key = ""+i+"_"+j+"_"+flag;
        if(aux.containsKey(key))
            return aux.get(key);
        int count = 0;
        for(int k=i+1;k<j;k+=2) {
            char op = s.charAt(k);
            int LT = helper(s,true,i,k-1);
            int RT = helper(s,true,k+1,j);
            
            int LF = helper(s,false,i,k-1);
            int RF = helper(s,false,k+1,j);
            
            if(op == '&') {
                if(flag)
                    count += LT*RT;
                else
                    count += (LT*RF + LF*RF + LF*RT);
            }
            else if(op == '|') {
                if(flag)
                    count += (LT*RT + LT*RF + LF*RT);
                else
                    count += LF*RF;
            }
            else {
                if(flag)
                    count += (LT*RF + LF*RT);
                else
                    count += (LT*RT + LF*RF);
            }
        }
        aux.put(key,count%MOD);
        return count%MOD;
    }
}
