/*
Given a Queue Q containing N elements. The task is to reverse the Queue. Your task is to complete the function rev(), that reverses the N elements of the queue.
Example 1:

Input:
6
4 3 1 10 2 6

Output: 
6 2 10 1 3 4
*/

class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        int n = q.size();
        if(n == 1)
            return q;
        Stack<Integer> aux = new Stack<>();
        while(!q.isEmpty())
            aux.push(q.poll());
        while(!aux.isEmpty())
            q.add(aux.pop());
        return q;
    }
}
