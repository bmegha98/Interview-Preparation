//Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(k == 1) {
            for(int ele : arr)
                res.add(ele);
            return res;
        }
        
        Deque<Integer> aux = new LinkedList<>();
        int i;
        for(i=0;i<k;i++) {
            while(!aux.isEmpty() && arr[i]>= arr[aux.peekLast()])
                aux.pollLast();
            aux.addLast(i);
        }
        
        for(i=k;i<n;i++) {
            res.add(arr[aux.peekFirst()]);
            while(!aux.isEmpty() && arr[i]>= arr[aux.peekLast()])
                aux.pollLast();
            while(!aux.isEmpty() && aux.peekFirst() <= i-k)
                aux.pollFirst();
            aux.addLast(i);
        }
        res.add(arr[aux.peekFirst()]);
        return res;
    }
}
