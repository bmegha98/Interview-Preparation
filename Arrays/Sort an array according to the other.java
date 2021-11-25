/*
Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort the first array A1[ ] such that all the relative positions of the elements in the first 
array are the same as the elements in the second array A2[ ].
See example for better understanding.
Note: If elements are repeated in the second array, consider their first occurance only.

Example 1:

Input:
N = 11 
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {2, 1, 8, 3}
Output: 
2 2 1 1 8 8 3 5 6 7 9
Explanation: Array elements of A1[] are
sorted according to A2[]. So 2 comes first
then 1 comes, then comes 8, then finally 3
comes, now we append remaining elements in
sorted order.
Example 2:

Input:
N = 11 
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {99, 22, 444, 56}
Output: 
1 1 2 2 3 5 6 7 8 8 9
Explanation: No A1[] elements are in A2[]
so we cannot sort A1[] according to A2[].
Hence we sort the elements in non-decreasing 
order.
*/

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        Arrays.sort(A1);
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<M;i++) 
            if(!indexMap.containsKey(A2[i]))
                indexMap.put(A2[i],i);
                
        int k = M;      // A2 = {1,2,2,2,6} A1= {2,6,1,8}
        List<Integer> tmp = new ArrayList<>();
        
        for(int i=0;i<N;i++) {
            if(!indexMap.containsKey(A1[i]))
                indexMap.put(A1[i],k++);
            
            tmp.add(A1[i]);    
        }

        Collections.sort(tmp, (a,b)-> indexMap.get(a)-indexMap.get(b));
        
        for(int i=0;i<N;i++)
            A1[i] = tmp.get(i);
        return A1;
    }
}


//Storing Frequency

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        Map<Integer,Integer> freqMap = new TreeMap<>();
        
        for(int i=0;i<N;i++)
            freqMap.put(A1[i], freqMap.getOrDefault(A1[i],0)+1);
            
        int k = 0;
        for(int i=0;i<M;i++) {
            int ele = A2[i];
            if(freqMap.containsKey(ele)) {
                int f = freqMap.get(ele);
                while(f-- > 0)
                    A1[k++] = ele;
                freqMap.remove(ele);
            }
        }
        
        for(int key : freqMap.keySet()) {
            int f = freqMap.get(key);
                while(f-- > 0)
                    A1[k++] = key;
        }
            
    
        return A1;
    }
}
