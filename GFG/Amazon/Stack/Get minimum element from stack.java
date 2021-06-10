/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.
Your Task:
You are required to complete the three methods push() which take one argument an integer 'x' to be pushed into the stack, pop() which returns a integer poped out
from the stack and getMin() which returns the min element from the stack. (-1 will be returned if for pop() and getMin() the stack is empty.)

Expected Time Complexity : O(1) for all the 3 methods.
Expected Auixilliary Space : O(1) for all the 3 methods.
*/

class GfG
{
    int minEle;
    Stack<Integer> s= new Stack<>();

    int getMin()
	{
		if(s.isEmpty())
			return -1;
		else
			return minEle;
	}
	int pop()
	{
		if(s.isEmpty())
			return -1;
		
		int t = s.pop();
		if(t < minEle)
		{
			int k = minEle;
			minEle = 2*minEle - t;
			return k;
		}
		else 
		{
			return t;
		}
	}
	void push(int x)
	{
		if(s.isEmpty()){
			minEle = x;
			s.push(x);
			return ;
		}
		else if(x < minEle){
			s.push(2*x - minEle);
			minEle = x;
		}
		else{
			s.push(x);
		}
	}	
}
