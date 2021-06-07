/*
Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative 
order.
Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Example 1:

Input:
5 3
1 2 3 4 5

Output: 
3 2 1 4 5
*/

class GfG
{
    //Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int n = q.size();
        if(k == 1)
            return q;
        Stack<Integer> aux = new Stack<>();
        for(int i=0;i<k;i++)
            aux.push(q.poll());
        while(!aux.isEmpty())
            q.add(aux.pop());
        
        int rem = n-k;
        for(int i=0;i<rem;i++)
            q.add(q.poll());
        return q;
    }
}
