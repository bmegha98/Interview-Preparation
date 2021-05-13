/*
Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. 
He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, 
say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.
*/

//BackTracking+DP , T(n) = O(n^2*k) , space = O(nk)
class Solution{
    static long minTime(int[] arr,int n,int k){
        if(n == 1)
            return arr[0];
        
        int[] sumArray = new int[n+1];
        sumArray[0] = 0;
        for(int i = 1;i<=n;i++)
            sumArray[i] = sumArray[i-1]+arr[i-1];
        if(k == 1)
            return sumArray[n];
            
        //T[k][n] = min{ for P = 1 to n : max{T[k-1][P],sumArray[P]}}
        
        int[][] T = new int[k+1][n+1];
        
        for(int i = 1;i<=k;i++)         //k painters,1 painting
            T[i][1] = arr[0];
        for(int j = 1;j<=n;j++)         //1 painter, n paintings
            T[1][j] = T[1][j-1]+arr[j-1];
            
        for(int i=2;i<=k;i++) {
            for(int j = 2;j<=n;j++) {
                int res = Integer.MAX_VALUE;
                
                for(int P = 1;P<=j;P++) {
                    int tmp = sumArray[j]-sumArray[P];
                    //if(i == 2 && j == 5)
                      //  System.out.print(tmp+" ");
                    res = Math.min(res, Math.max(T[i-1][P],tmp));
                }
                T[i][j] = res;
                //System.out.println();
                //System.out.println(T[i][j]);
            }
        }
        return T[k][n];
    }
}

//T(n) = O(sum(A)) , space = O(1)

class Solution{
    static long minTime(int[] arr,int n,int k){
        if(n == 1)
            return arr[0];
        
        long minTime = getMax(arr); //n painters
        long maxTime = getSum(arr); //1 painter
        
        long res =  Integer.MAX_VALUE;
        
        while(minTime <= maxTime) {
            long mid = minTime+(maxTime-minTime)/2;
            int paintersReq = getPaintersCount(arr,mid);
            
            if(paintersReq > k)   //increase time
                minTime = mid+1;
            else {
                res = mid;
                maxTime = mid-1;
            }
        }
        return res;
    }
    
    private static int getPaintersCount(int[] A,long maxTime) {
        int painters = 1,time = 0;
        for(int ele : A) {
            time += ele;
            if(time > maxTime) {
                time = ele;
                painters++;
            }
        }
        return painters;
    }
    
    private static long getMax(int[] A) {
        long ans = 0;
        for(int ele : A) 
            ans = Math.max(ans,ele);
        return ans;
    }
    
    private static long getSum(int[] A) {
        long sum = 0;
        for(int ele : A)
            sum += ele;
        return sum;
    }
}
