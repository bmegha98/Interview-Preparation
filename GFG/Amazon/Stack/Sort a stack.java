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
*/

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    int n = s.size();
		if(n < 2)
		    return s;
		Stack<Integer> aux = new Stack<>();
		
		while(!s.isEmpty()) {
		    int ele = s.pop();
		    while(!aux.isEmpty() && aux.peek() < ele)
		        s.push(aux.pop());
		    aux.push(ele);
		}
		while(!aux.isEmpty())
		    s.push(aux.pop());
		return s;
	}
}
