/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

num = 87, den = 22 , return "3.9(54)"

The idea is to first calculate the integral quotient (absolute part before decimal point) and then calculate the fractional part. To check if the fractional part
is repeating, insert the remainder (numerator % denominator) in a map with key as remainder and value as the index position at which this remainder occurs. 
If at any point of time, the remainder becomes zero, then there doesn’t exist a repeating fraction otherwise if the remainder is already found in the map,
then there exists a repeating fraction.
*/

public class Solution {
    public String fractionToDecimal(int A, int B) {
        StringBuilder ans = new StringBuilder("");
        if(A == 0)
        {
            ans.append("0");
            return ans.toString();
        }
        
        long x = (long)A, y = (long)B;
        boolean isANeg = x<0;
        boolean isBNeg = y<0;
        
        if((isANeg&&!isBNeg)||(!isANeg&&isBNeg))
            ans.append("-");
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        long q = x/y;
        long rem = x%y;
        ans.append(q);
        if(rem == 0)
            return ans.toString();
        ans.append(".");
        Map<Long,Integer> aux = new HashMap<>();
        while(rem != 0 && !aux.containsKey(rem)) {
            aux.put(rem,ans.length());
            rem *= 10;
            q = rem/y;
            rem = rem%y;
            ans.append(q);
        }
        
        if(aux.containsKey(rem)) {
            ans.insert(aux.get(rem),"(");
            ans.append(')');
        }
        return ans.toString();
    }
}
