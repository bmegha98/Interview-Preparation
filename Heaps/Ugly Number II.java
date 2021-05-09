/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
*/

//T(n) = O(n) , space = O(n)
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        Queue<Long> q2 = new LinkedList<>();
        Queue<Long> q3 = new LinkedList<>();
        Queue<Long> q5 = new LinkedList<>();
        
        q2.add(2L);
        q3.add(3L);
        q5.add(5L);
        
        long min = 1;
        while(n-- > 1) {
            min = Math.min(Math.min(q2.peek(),q3.peek()),q5.peek());
            if(min == q2.peek())
            {
                q2.poll();
                q2.add(min*2);
                q3.add(min*3);
                q5.add(min*5);
            }
            else if(min == q3.peek()) {
                q3.poll();
                q3.add(3*min);
                q5.add(5*min);
            }
            else {
                q5.poll();
                q5.add(5*min);
            }
        }
        return (int)min;
    }
}

//T(n) = O(n) , space = O(n)
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        int[] A = new int[n];
        A[0] = 1;
        int i2=0,i3=0,i5=0;
        for(int i = 1;i<n;i++){
            int res = Math.min(Math.min(2*A[i2],3*A[i3]),5*A[i5]);
            A[i] = res;
            if(res == 2*A[i2])
                i2++;
            if(res == 3*A[i3])
                i3++;
            if(res == 5*A[i5])
                i5++;
        }
        return A[n-1];
    }
}
