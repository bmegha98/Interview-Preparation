/*
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. 
(The sorted stack is printed by the driver's code by popping the elements of the stack.)
*/

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.isEmpty())
		    return s;
		sortStack(s);
		return s;
	}
	
	private void sortStack(Stack<Integer> s) {
	    if(s.isEmpty())
	        return;
	    int ele = s.pop();
	    sortStack(s);
	    insertIntoStack(s,ele);
	}
	
	private void insertIntoStack(Stack<Integer> s, int ele) {
	    if(s.isEmpty() || s.peek() <= ele) {
	        s.push(ele);
	        return;
	    }
	    
	    int data = s.pop();
	    insertIntoStack(s,ele);
	    s.push(data);
	}
}
