/*
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s,
extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).
Example 2:

Input: str = "27"
Output: 1
Explanation: "27" can be decoded as "BG".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes the string as str as input parameter and returns the total
number of ways the string can be decoded modulo 109 + 7.
*/

//Using Memoization
class Solution
{
    int MOD = 1000000007;
    Map<Integer,Integer> aux;
    public int CountWays(String str)
    {
        // code here
        int n = str.length();
        if(n == 1)
            return str.charAt(0) == '0'?0:1;
        aux = new HashMap<>();
        return helper(str, n)%MOD;
    }
    
    private int helper(String str, int n) {
        //System.out.println(n);
        if(n == 0)
            return 1;
        if(n == 1)
            return str.charAt(0) == '0'?0:1;
        if(aux.containsKey(n))
            return aux.get(n);
        char f = str.charAt(n-1);
        int count1 = 0, count2 = 0;
        if(f > '0' && f <= '9')
            count1 = helper(str, n-1);
        String s = str.substring(n-2,n);
        //System.out.println(s);
        if(s.charAt(0) != '0') {
            int num = Integer.parseInt(s);
            if(num <= 26)
                count2 = helper(str, n-2);
        }
        int res = count1+count2;
        aux.put(n,res);
        return res;
    }
}

//Using Tabulation
class Solution
{
    int MOD = 1000000007;
    public int CountWays(String str)
    {
        // code here
        if(str.charAt(0) == '0')
            return 0;
        int n = str.length();
        if(n == 1)
            return 1;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        
        for(int i=2;i<=n;i++) {
            char f = str.charAt(i-1);
            if(f > '0')
                count[i] = count[i-1];
            int y = Integer.valueOf(str.substring(i-2,i));
            if(y >= 10 && y < 27)
                count[i] = (count[i]+count[i-2])%MOD;
        }
        return count[n];
    }
}
