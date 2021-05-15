/*
Given an array arr[ ] of length N consisting cost of N toys and an integer K depicting the amount with you. Your task is to find maximum number of toys you can buy
with K amount. 
*/

class Solution{
    static int toyCount(int N, int K, int arr[])
    {
        if(N == 1)
            return arr[0] <= K?1:0;
        int count = 0;
        Arrays.sort(arr);
        int i = 0;
        while(i < N && K > 0) {
            int cost = arr[i++];
            if(cost > K)
                break;
            if(cost == K) {
                count++;
                break;
            }
            count++;
            K -= cost;
        }
        return count;
    }
}
