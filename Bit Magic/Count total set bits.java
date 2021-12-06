/*
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.
*/

//TLE
class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        if(n == 0)
            return 0;
        int[] T = new int[n+1];
        T[1] = 1;
        int count = 1;
        for(int i=2;i<=n;i++) {
            if(i%2 == 0)
                T[i] = T[i/2];
            else
                T[i] = T[i/2]+1;
            count += T[i];
        }
        
        return count;
    }
}

//Optimized
class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        if(n == 0)
            return 0;
        int x = largestPowerOf2LessThan(n);
        int R1 = (1 <<(x-1))*x;
        int R2 = n-(1<<x)+1;
        
        return R1+R2+countSetBits(R2-1);
    }
    
    private static int largestPowerOf2LessThan(int n) {
        int x = 0;
        while((1<<x) <= n)
            x++;
        return x-1;
    }
}
