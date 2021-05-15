/*
There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The balls in first road are given in an array a and
balls in the second road in an array b. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts
from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side
of the road).
Geek can change the road only at a point of intersection ie- a point where buckets have the same number of balls on two roads. Help Geek collect the maximum number
of balls.
Example 1:

Input: 
N = 5, M = 5
a[] = {1, 4, 5, 6, 8}
b[] = {2, 3, 4, 6, 9}
Output: 29
Explaination: The optimal way to get the 
maximum number of balls is to start from 
road 2. Get 2+3. Then switch at intersection 
point 4. Get 4+5+6. Then switch at intersection
point 6. Get 9. Total = 2+3+4+5+6+9 = 29.
*/

class Solution{
    static int maxBalls(int N, int M, int a[], int b[])
    {
        // code here
        int res = 0;
        int sum1 = 0,sum2= 0,i=0,j=0;
        while(i < N && j < M) {
            if(a[i] < b[j]){
                sum1 += a[i];
                i++;
            }
            else if(a[i]>b[j]) {
                sum2 += b[j];
                j++;
            }
            else {
                //Duplicates can be present
                sum1 += a[i];
                while(i+1 < N && a[i+1] == b[j]) {
                    i++;
                    sum1 += a[i];
                }
                sum2 += b[j];
                while(j+1 < M && b[j+1]==a[i]) {
                    j++;
                    sum2 += b[j];
                }
            
                
                res += Math.max(sum1,sum2);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        

        while(i < N)
            sum1 += a[i++];
        while(j < M)
            sum2 += b[j++];

        res += Math.max(sum1,sum2);
        return res;
    }
}
