/*
The set [1,2,3,…,n] contains a total of n! unique permutations.By listing and labeling all of the permutations in order,We get the following sequence 
(ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
 In this case, just concatenate the number to the answer.
so if n = 11, k = 1, ans = "1234567891011" 
Whats the maximum value of n and k?
 In this case, k will be a positive integer thats less than INT_MAX.
n is reasonable enough to make sure the answer does not bloat up a lot.

determine each digit from MSD to LSD
n = 4 , k = 14, digits = [1,2,3,4]
- - - -
fixing first digit, there will be 3! permutations
So, there will be 4 blocks, each of size 3!.

blockIndex = k/fact(n-1) check for boundary condition if(k%fact(n-1) == 0) then blockIndex -= 1
ans += String.valueOf(digits.get(blockIndex))
digits.remove (blockIndex)

k -= (blockIndex * blockSize)
*/

public class Solution {
    List<Integer> digits;
    long[] fact;
    public String getPermutation(int n, int k) {
        fact = new long[n+1];
        fact[0] = 1;
        fact[1] = 1;
        
        for(int i=2;i<=n;i++)
            fact[i] = i*fact[i-1];
            
        if(k > factorial(n))
            return "";
        digits = new ArrayList<>();
        for(int i=1;i<=n;i++)
            digits.add(i);
        return helper(n,k);
    }
    private String helper(int n, int k) {
        if(n == 0)
            return "";
        int f = factorial(n-1);
        int blockIndex = k/f;
        if(k%f == 0)            //boundary condition
            blockIndex--;
        int num = digits.get(blockIndex);
        digits.remove(blockIndex);
        k -= (f*blockIndex);
        return num+helper(n-1,k);
    }
    
    private int factorial(int n) {
        if(n > 12)
            return Integer.MAX_VALUE;
        
        return (int)fact[n];
    }
}
