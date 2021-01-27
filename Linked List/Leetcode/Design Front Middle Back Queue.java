/*
Design a queue that supports push and pop operations in the front, middle, and back.

Implement the FrontMiddleBack class:

FrontMiddleBack() Initializes the queue.
void pushFront(int val) Adds val to the front of the queue.
void pushMiddle(int val) Adds val to the middle of the queue.
void pushBack(int val) Adds val to the back of the queue.
int popFront() Removes the front element of the queue and returns it. If the queue is empty, return -1.
int popMiddle() Removes the middle element of the queue and returns it. If the queue is empty, return -1.
int popBack() Removes the back element of the queue and returns it. If the queue is empty, return -1.
Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example:

Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6].
 

Example 1:

Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]

Explanation:
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
q.popFront();     // return 1 -> [4, 3, 2]
q.popMiddle();    // return 3 -> [4, 2]
q.popMiddle();    // return 4 -> [2]
q.popBack();      // return 2 -> []
q.popFront();     // return -1 -> [] (The queue is empty)
*/

//Using Collections Framework
class FrontMiddleBackQueue 
{
    LinkedList<Integer> l;
    public FrontMiddleBackQueue() {
        l = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        l.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        l.add(l.size()/2,val);
    }
    
    public void pushBack(int val) {
        l.addLast(val);
    }
    
    public int popFront() {
        return l.isEmpty()?-1:l.pollFirst();
    }
    
    public int popMiddle() {
        int n = l.size();
        if(n == 0)
            return -1;
        return l.remove(n%2 == 0 ? n/2-1:n/2);
    }
    
    public int popBack() {
        return l.isEmpty()?-1:l.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
 
 
//Using Doubly Linked List

class Node
{
    int val;
    Node next,prev;

    Node(int v)
    {
        val = v;
        next = null;
        prev = null;
    }
}
class FrontMiddleBackQueue 
{
    Node head,tail;
    public FrontMiddleBackQueue() 
    {
        head = null;
        tail = null;
    }
    void printList()
    {
        Node curr = head;
        while(curr != null)
        {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    Node getMiddlePush()
    {
        Node curr = head;
        if(curr == null || curr.next == null)
            return curr;
        Node slow = curr,fast = curr;
        while(fast != null && fast.next != null)
        {
             fast = fast.next.next;
             slow = slow.next;
        }
        return slow;
    }
    Node getMiddlePop()
    {
        if(head == null || head.next == null)
            return head;
        Node slow = head,fast = head.next;
        while(fast != null)
        {
            fast = fast.next;
            if(fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public void pushFront(int val) 
    {
        Node n = new Node(val);
        if(head == null)
        {
            head = n;
            tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
        //printList();
    }
    
    public void pushMiddle(int val) 
    {
        Node n = new Node(val);
        if(head == null)
        {
            head = n;
            tail = n;
            return;
        }
      
        Node mid = getMiddlePush();
        Node p = mid.prev;
        if(p == null)
            head = n;
        else
            p.next = n;
        n.next = mid;
        n.prev = p;
        if(mid != null)
            mid.prev = n;
        //printList();
    }
    
    public void pushBack(int val) 
    {
        Node n = new Node(val);
        if(head == null)
        {
            head = n;
            tail = n;
            return;
        }
        n.prev = tail;
        tail.next = n;
        tail = n;
       // printList();
    }
    
    public int popFront() 
    {
        if(head == null)
            return -1;
        Node res = head;
        head = head.next;
        if(head == null)
            tail = null;
        else
            head.prev = null;
       // printList();
        return res.val;
    }
    
    public int popMiddle() 
    {
        Node mid = getMiddlePop();
        if(mid == null)
            return -1;
        if(mid == head && mid == tail)
        {
            head = null;
            tail = null;
            return mid.val;
        }
        
        if(mid.prev != null)
            mid.prev.next = mid.next;
        if(mid.next != null)
            mid.next.prev = mid.prev;
        //printList();
        if(mid == head)
            head = mid.next;
        return mid.val;
    }
    
    public int popBack() 
    {
        if(tail == null)
            return -1;
        Node res = tail;
        tail = tail.prev;
        if(tail == null)
            head = null;
        else
            tail.next = null;
        
        //printList();
        return res.val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
