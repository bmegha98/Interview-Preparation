//For an integer N find the number of trailing zeroes in N!.

class Solution{
    static int trailingZeroes(int N){
        // Write your code here
        if(N < 5)
            return 0;
        if(N == 5)
            return 1;
        int count = 0;
        while(N > 0) {
            N /= 5;
            count += N;
        }
        return count;
    }
}
