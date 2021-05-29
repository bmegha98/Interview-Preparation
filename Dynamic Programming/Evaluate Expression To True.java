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
Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates 
to true in 4 ways ((T|T)&(F^T)), 
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
*/

/*
Place parenthesization at each operator and check for left and right expression, count ways expression evaluates to true and false.
*/

public class Solution {
    Map<String,Integer> aux = new HashMap<>();
    public int cnttrue(String A) {
        int n = A.length();
        if(n == 1)
            return A.charAt(0) == 'T'?1:0;
        
        char[] S = A.toCharArray();
        return solve(S,0,n-1,true);
    }
    private  int solve(char[] S,int i,int j,boolean res) {
        if(i > j)
            return 0;
        if(i == j) {
            if(res)
                return S[i] == 'T'?1:0;
            return S[i] == 'F'?1:0;
        }
        String key = i+" "+j+" "+res;
        
        if(aux.containsKey(key))
            return aux.get(key);
        
        int ans = 0;
        for(int k = i+1;k<=j-1;k=k+2) {
            int lT = solve(S,i,k-1,true);
            int lF = solve(S,i,k-1,false);
            int rT = solve(S,k+1,j,true);
            int rF = solve(S,k+1,j,false);
            
            if(S[k] == '&'){
                if(res)
                    ans += lT*rT;
                else
                    ans += lT*rF + lF*rT + lF*rF;
            }
            else if(S[k] == '|') {
                if(res)
                    ans += lT*rF + lF*rT + lT*rT;
                else
                    ans += lF*rF;
            }
            else if(S[k] == '^'){
                if(res)
                    ans += lT*rF + lF*rT;
                else
                    ans += lT*rT + lF*rF;
            }
        }
        ans %= 1003;
        aux.put(key,ans);
        return ans;
    }
}

