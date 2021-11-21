/*
Imagine you have a special keyboard with the following keys: 

Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Find maximum numbers of A's that can be produced by pressing keys on the special keyboard N times. 


Example 1:

Input: N = 3
Output: 3
Explaination: Press key 1 three times.

Example 2:

Input: N = 7
Output: 9
Explaination: The best key sequence is key 1, key 1, key 1, key 2, key 3, key4, key 4.
*/

class Solution{
    static int optimalKeys(int N){
        // code here
        if(N <= 6)
            return N;
        // int res = N;
        // for(int i=N-3;i>=1;i--)
        //     res = Math.max(res, (N-i-1)*optimalKeys(i));
        // return res;
        
        //3 keys are required : CtrlA, CtrlC, CtrlV  (1 CtrlV)
        // 2 CtrlV ...... (N-3) CtrlV
        
        int[] T = new int[N+1];
        for(int i=1;i<=6;i++)
            T[i] = i;
        for(int i=7;i<=N;i++) {
            T[i] = i;
            for(int j=i-3;j>=1;j--)
                T[i] = Math.max(T[i], (i-j-1)*T[j]);
        }
        return T[N];    
    }
}
