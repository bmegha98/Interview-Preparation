/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
*/

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	    // Your code here	
	    int n = petrol.length;
	    int start = 0, end = 1;
	    int bal = petrol[0]-distance[0];
	    
	    while(start != end || bal < 0) {
	        while(start != end && bal < 0) {
	            bal -= (petrol[start]-distance[start]);
	            start = (start+1)%n;
	            if(start == 0)
	                return -1;
	        }
	        
	        bal += (petrol[end]-distance[end]);
	        end = (end+1)%n;
	    }
	    return start;
    }
}
