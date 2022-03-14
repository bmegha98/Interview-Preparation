/*
Given a sorted deck of cards numbered 1 to N.

1) We pick up 1 card and put it on the back of the deck.

2) Now, we pick up another card, it turns out to be card number 1, we put it outside the deck.

3) Now we pick up 2 cards and put it on the back of the deck.

4) Now, we pick up another card and it turns out to be card numbered 2, we put it outside the deck. ...

We perform this step until the last card.

If such an arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N then output -1.

Example 1:

Input:
N = 4
Output: 2 1 4 3
Explanation:
We initially have [2 1 4 3]
In Step1, we move the first card to the end. 
Deck now is: [1 4 3 2]
In Step2, we get 1. Hence we remove it. Deck 
now is: [4 3 2]
In Step3, we move the 2 front cards ony by one 
to the end  ([4 3 2] -> [3 2 4] -> [2 4 3]).
Deck now is: [2 4 3]
In Step4, we get 2. Hence we remove it. Deck 
now is: [4 3]
In Step5, the following sequence follows: 
[4 3] -> [3 4] -> [4 3] -> [3 4]. Deck now 
is: [3 4]
In Step6, we get 3. Hence we remove it. Deck 
now is: [4] Finally, we're left with a single 
card and thus, we stop. 
 

Example 2:

Input:
N = 5
Output: 3 1 4 5 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rotation() which takes the integer N as input parameters and returns If
such arrangement of decks is possible, return the arrangement, if it is not possible for a particular value of n then return -1.
*/

/*
The logic is simple:
For N =4 Create an array of len (4 )

so arr = [ _ , _ , _, _ ] and our cur empty position is at 0th index We will Insert from 1 to 4 Iteratively :

For 1 we will skip 1 empty position from cur_empty
We get that cur_idx =1 after we skipped 1 empty position so put 1 at index 1 arr =[ _ 1 , _, _ ]

For 2 we will skip 2 empty position from cur_empy which is 1 so we get new cur_idx =0 after skipping 2 positions
arr= [ 2,1_,_]

For 3 skip 3 posiition that are empty from cur_idx and we get cur_idx =3 .
arr=[21,_,3]
Similarly fill 4
*/

class Solution{
    
    ArrayList<Integer> rotation(int N){
        // Code Here
        ArrayList<Integer> res = new ArrayList<>();
        int[] tmp = new int[N];
        int k = 0;
        for(int i=1;i<=N;i++) {
            int j = i;
            while(j > 0) {
                if(tmp[k] == 0)
                    j--;
                k = (k+1)%N;
            }
            while(tmp[k%N]!=0)
                k = (k+1)%N;
            tmp[k] = i;
        }
        
        for(int i=0;i<N;i++) {
            res.add(tmp[i]);
        }
        return res;
    }
    
}
