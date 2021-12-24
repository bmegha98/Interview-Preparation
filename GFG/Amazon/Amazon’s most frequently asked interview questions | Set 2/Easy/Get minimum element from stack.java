/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.

Example 1:

Input:
push(2)
push(3)
pop()
getMin()
push(1)
getMin()
Output: 3 2 1
Explanation: In the first test case for
query 
push(2)  the stack will be {2}
push(3)  the stack will be {2 3}
pop()    poped element will be 3 the
         stack will be {2}
getMin() min element will be 2 
push(1)  the stack will be {2 1}
getMin() min element will be 1
*/

class GfG
{
    int minEle;
    Stack<Integer> s;

    public GfG() {
        s = new Stack<>();
        minEle = -1;
    }
    /*returns min element from stack*/
    int getMin()
    {
	    // Your code here
	    if(s.isEmpty())
	        return -1;
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    // Your code here
	    if(s.isEmpty())
	        return -1;
	    int y = s.pop();
	    if(y > minEle)
	        return y;
	    int res = minEle;
	    minEle = 2*minEle-y;
	    return res;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    // Your code here	
	    if(s.isEmpty()) {
	        s.push(x);
	        minEle = x;
	    } else {
	        if(x >= minEle)
	            s.push(x);
	        else {
	            int y = 2*x-minEle;
	            s.push(y);
	            minEle = x;
	        }
	    }
    }	
}
