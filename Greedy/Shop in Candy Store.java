/*
In a candy store, there are N different types of candies available and the prices of all the N different types of candies are provided to you.
You are now provided with an attractive offer.
You can buy a single candy from the store and get at most K other candies ( all are different types ) for free.
Now you have to answer two questions. Firstly, you have to find what is the minimum amount of money you have to spend to buy all the N different candies. Secondly,
you have to find what is the maximum amount of money you have to spend to buy all the N different candies.
In both the cases you must utilize the offer i.e. you buy one candy and get K other candies for free.
*/

class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        ArrayList<Integer> res = new ArrayList<>();
        if(N == 1) {
            res.add(candies[0]);
            res.add(candies[0]);
            return res;
        }
        
        int minAmt = 0,maxAmt = 0;
        
        Arrays.sort(candies);
        int i = 0,j=N-1;
        while(i <= j) {
            minAmt += candies[i];
            j -= K;
            if(i>=j)
                break;
            i++;
        }
        
        i = N-1;
        j = 0;
        while(i >= j) {
            maxAmt += candies[i];
            j += K;
            if(j >= i)
                break;
            i--;
        }
        
        res.add(minAmt);
        res.add(maxAmt);
        return res;
    }
}
