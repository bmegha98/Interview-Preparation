/*
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

Example 1:

Input:
N = 4
X[] = 5,15,1,3
Output:
5
10
5
4
*/

class Solution
{
    static Queue<Integer> minHeap = new PriorityQueue<>();
    static Queue<Integer> maxHeap = new PriorityQueue<>(1,Collections.reverseOrder());
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        // add your code here
        maxHeap.add(x);
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
      //Time = O(logn)
       if(maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        return (minHeap.peek()+maxHeap.peek())/2;
    }
    
}
