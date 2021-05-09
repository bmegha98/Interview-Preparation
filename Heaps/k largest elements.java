//Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        int[] res = new int[k];
        Queue<Integer> aux = new PriorityQueue<>();
        for(int i =0;i<n;i++) {
            aux.add(arr[i]);
            if(aux.size() > k)
                aux.poll();
        }
        
        for(int i = k-1;i>=0;i--)
            res[i] = aux.poll();
        return res;
    }
}
