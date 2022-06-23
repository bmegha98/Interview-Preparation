/*
There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith
course should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.

 

Example 1:

Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
Explanation: 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
Example 2:

Input: courses = [[1,2]]
Output: 1
Example 3:

Input: courses = [[3,2],[4,3]]
Output: 0
 

Constraints:

1 <= courses.length <= 104
1 <= durationi, lastDayi <= 104
*/

//For each course, we have 2 choices - include or exclude | Memoization
class Solution {
    Map<String,Integer> aux;
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if(n == 1)
            return courses[0][0] <= courses[0][1] ? 1 : 0;
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        aux = new HashMap<>();
        return helper(courses,0,n,0);
    }
    
    private int helper(int[][] arr, int start, int n, int currTime) {
        if(start == n) 
            return 0;
        
        String k = ""+start+"_"+currTime;
        if(aux.containsKey(k))
            return aux.get(k);
        
        int res = 0;
        if(currTime+arr[start][0] <= arr[start][1])
            res = 1+helper(arr,start+1,n,currTime+arr[start][0]);
        res = Math.max(res, helper(arr,start+1,n,currTime));
        aux.put(k,res);
        return res;
    }
}

//For each task <duration,end> if currTime+duration > end then check if on swapping with largest duration task, currTime remains same or decreased.
class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if(n == 1)
            return courses[0][0] <= courses[0][1] ? 1 : 0;
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        Queue<Integer> aux = new PriorityQueue<>(1, (a,b) -> {
            return b-a;
        });
        
        int currTime = 0, res = 0;
        for(int i=0;i<n;i++) {
            int[] curr = courses[i];
            
            if(currTime+curr[0] <= curr[1]) {
                currTime += curr[0];
                aux.add(curr[0]);
            }
                
            else {
                if(!aux.isEmpty() && aux.peek() > curr[0]) {
                    currTime += (curr[0]-aux.peek());
                    aux.poll();
                    aux.add(curr[0]);
                }
            }
        }
        return aux.size();                                      
    }
}
