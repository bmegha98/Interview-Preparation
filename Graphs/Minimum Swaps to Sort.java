//Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.

//T(n) = O(n*n) , space = O(1)

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        if(n == 1)
            return 0;
        int ans = 0;
        for(int i = 0;i<n-1;i++) {
            int minInd = i;
            for(int j = i+1;j<n;j++) 
                if(nums[j] < nums[minInd])
                    minInd = j;
            
            if(i != minInd) {
                ans++;
                swap(nums,i,minInd);
            }
        }
        return ans;
    }
    private void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

//T(n) = O(nlogn) , space = O(n)
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        if(n == 1)
            return 0;
        int ans = 0;
        int[] tmp = Arrays.copyOf(nums,n);
        Arrays.sort(tmp);
        
        Map<Integer,Integer> aux = new HashMap<>();
        for(int i=0;i<n;i++)
            aux.put(nums[i],i);
            
        for(int i = 0;i<n;i++) {
           if(nums[i] != tmp[i]) {
               int j = aux.get(tmp[i]);
               swap(nums,i,j);
               ans++;
               aux.put(tmp[i],i);
               aux.put(nums[j],j);
           }
        }
        return ans;
    }
    private void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
