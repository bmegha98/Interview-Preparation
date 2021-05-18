/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.
*/

//Alice will check for every number x < n and divides n , opponent fails or not
//Exponential Time Complexity
class Solution {
    public boolean divisorGame(int n) {
        if(n == 1)
            return false;
        if(n == 2)
            return true;
        for(int i=1;i<n;i++)
            if(n % i == 0 && !divisorGame(n-i))
                return true;
        return false;
    }
}

//With Memoization
//T(n) = O(n^2) Space = O(n)
class Solution {
    int[] T = new int[1001];
    public Solution() {
        Arrays.fill(T,-1);
        T[1] = 0;
        T[2] = 1;
    }
    public boolean divisorGame(int n) {
        if(n == 1)
            return false;
        if(T[n] != -1)
            return T[n]==0?false:true;
        for(int i=1;i<n;i++)
            if(n % i == 0 && !divisorGame(n-i)) {
                T[n] = 1;
                return true;
            }
        T[n] = 0;
        return false;
    }
}

//With Tabulation
//T(n) = O(n^2) Space = O(n)
class Solution {
    public boolean divisorGame(int n) {
        if(n == 1)
            return false;
        if(n == 2)
            return true;
        boolean[] T = new boolean[1001];
        T[2] = true;
        
        for(int i = 3;i<=n;i++)
            for(int j = 1;j<i;j++)
                if(i%j == 0 && !T[i-j]){
                    T[i] = true;
                    break;
                }
        
        return T[n];
    }
}

//Mathematical
/*
Divisors of an odd number are odd .
Even-Odd = Odd , Odd-Odd = Even
If you get an even number, give an odd number to your opponent (by sub 1 from it). The opponent will have no choice but to give an even number back.
In this way, you'll always get an even number, opponent will meet 1 and lose.
*/
//T(n) = O(1) , space = O(1)
class Solution {
    public boolean divisorGame(int n) {
        if(n == 1)
            return false;
        if(n == 2)
            return true;
        return n%2 == 0;
    }
}
