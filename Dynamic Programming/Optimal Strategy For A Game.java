/*
You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You
play against an opponent in an alternating way.
In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.
Example 1:

Input:
N = 4
A[] = {5,3,7,10}
Output: 15
Explanation: The user collects maximum
value as 15(10 + 5)

*/
/*Two choices
Pick first coin i.e. ith coin : Opponent can choose a coin from [i+1.....j] if opponent picks (i+1)th coin then we are left with [i+2...j] and if opponent
picks jth coin then we are left with [i+1...j-1] . Since opponent is playing equally optimal, he/she will pick that coin which will left me with min value i.e.
first = v[i] + min{OPT(i+1,j-1), OPT(i+2,j)}
Similary , on picking last coin max coin that can be collected is second = v[j] + min{OPT(i+1,j-1),OPT(i,j-2)}
Hence OPT(i,j) = max{first,last}
*/

class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long[][] T;
    static long countMaximum(int arr[], int n)
    {
        if(n == 2)
            return Math.max(arr[0],arr[1]);
        T = new long[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(T[i],-1);
        return optimalGame(arr,0,n-1);
    }
    static long optimalGame(int[] A, int i, int j) {
        if(i > j)
            return 0;
        if(i == j)
            return A[i];
        if(i+1 == j)
            return Math.max(A[i],A[j]);
        if(T[i][j] != -1)
            return T[i][j];
        long firstCoin = A[i]+Math.min(optimalGame(A,i+2,j),optimalGame(A,i+1,j-1));
        long lastCoin = A[j]+Math.min(optimalGame(A,i+1,j-1),optimalGame(A,i,j-2));
        
        return T[i][j]=Math.max(firstCoin,lastCoin);
    }
}

//Tabulation
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long[][] T;
    static long countMaximum(int arr[], int n)
    {
        if(n == 2)
            return Math.max(arr[0],arr[1]);
        T = new long[n][n];
        for(int i =0;i<n;i++) {
            T[i][i] = arr[i];
            if(i < n-1)
                T[i][i+1] = Math.max(arr[i],arr[i+1]);
        }
        
        for(int j = 2;j<n;j++) 
            for(int i = j-2;i>=0;i--) {
                long firstCoin = arr[i]+Math.min(T[i+1][j-1],T[i+2][j]);
                long lastCoin = arr[j]+Math.min(T[i+1][j-1],T[i][j-2]);
                T[i][j] = Math.max(firstCoin,lastCoin);
            }
        return T[0][n-1];
    }
}
