/*
Design a stack which supports the following operations.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in 
the stack.
*/

//Using Linked List
class ListNode
{
    int val;
    ListNode next,prev;
    public ListNode(int val,ListNode next,ListNode prev)
    {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class CustomStack {
    
    private ListNode head,tail;
    private int capacity;
    private int size;
    public CustomStack(int maxSize) {
        head = null;
        tail = null;
        capacity = maxSize;
        size = 0;
    }
    
    public void push(int x) {
        if(size == capacity)
            return;
        size++;
        ListNode n = new ListNode(x,head,null);
        if(head == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            head.prev = n;
            head = n;
        }
    }
    
    public int pop() 
    {
        if(size == 0)
            return -1;
        size--;
        int res = head.val;
        if(size == 0)
        {
            head = null;
            tail = null;
            return res;
        }
        head = head.next;
        if(head != null)
            head.prev = null;
        return res;
    }
    
    public void increment(int k, int val) 
    {
        if(tail == null)
            return;
        ListNode tmp = tail;
        while(tmp != null && k > 0)
        {
            tmp.val += val;
            tmp = tmp.prev;
            k--;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
 
 //Using Array
 
 class CustomStack {
    
    int[] stack;
    int capacity;
    int top;
    public CustomStack(int maxSize) {
        capacity = maxSize;
        stack = new int[capacity];
        top = -1;
    }
    
    public void push(int x) {
       
        if(top == capacity-1)
            return;
        stack[++top] = x;
    }
    
    public int pop() 
    {
        if(top == -1)
            return -1;
        return stack[top--];
    }
    
    public void increment(int k, int val) 
    {
        if(top == -1)
            return;
        for(int i = 0;i<=top && i<k;i++)
            stack[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
