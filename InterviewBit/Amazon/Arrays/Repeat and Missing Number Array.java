/*
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
*/
//Using freq array
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        int[] freq = new int[n+1];
        
        for(int ele : A)
            freq[ele]++;
        
        int[] res = new int[2];
        for(int i=1;i<=n;i++) {
            if(freq[i] == 0)
                res[1] = i;
            else if(freq[i] == 2)
                res[0] = i;
            if(res[0] != 0 && res[1] != 0)
                break;
        }
        return res;
    }
}

/*
Sum : sum of elements of array, sqSum = sum of square of elements of array, S = sum of n natural numbers , SS = sum of squares of first n natural numbers.
Sum = S + A - B
A-B = Sum-S. ............ 1)

sqSum = SS + A^2 - B^2
A+B = (SS-sqSum)/(A-B) ......... 2)

Let x = Sum-S , y = (SS-sqSum)/x

A = |x+y|/2 , B = |A-x|

if Sum is cancelled out with [1,n], it'll have extra element
if S is cancelled out with elements of A, it'll have unique element

therefore, if Sum>S then first = Max(a,b) and second = Min(a,b)
else first = Min(a,b) and second = Max(a,b)
*/
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        int[] res = new int[2];
        
        long sum = 0,sqSum = 0;
        for(int ele : A) {
            sum += ele;
            sqSum += ((long)ele)*ele;
        }
        
        long S = (n*(n+1))/2;
        long SS = (S*(2*n+1))/3;
        
        long x = sum-S;
        long y = (SS-sqSum)/x;
        
        long a = Math.abs((x+y)/2);
        long b = Math.abs((y-x)/2);
        int first,second;
        if(S > sum)
        {
            first = (int)Math.min(a,b);
            second = (int)Math.max(a,b);
        }
        else
        {
            first = (int)Math.max(a,b);
            second = (int)Math.min(a,b);
        }
        
        res[0] = first;
        res[1] = second;
        
        return res;
    }
}
