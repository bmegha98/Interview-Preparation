/*
Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.
Where:
A[i][0] = start time of the ith meeting.
A[i][1] = end time of the ith meeting.
Find the minimum number of conference rooms required so that all meetings can be done.

Problem Constraints
1 <= N <= 10
0 <= A[i][0] < A[i][1] <= 2 * 109

Input Format
The only argument given is the matrix A.

Output Format
Return the minimum number of conference rooms required so that all meetings can be done.

Example Input
Input 1:

 A = [      [0, 30]
            [5, 10]
            [15, 20]
     ]

Input 2:

 A =  [     [1, 18]
            [18, 23]
            [15, 29]
            [4, 15]
            [2, 11]
            [5, 13]
      ]


Example Output
Output 1:

 2
Output 2:

 4
if start of a meet == end of another meet then consider end first.
*/

class Meet {
    int time;
    char type;
    public Meet(int t, char c) {
        time = t;
        type = c;
    }
    public int getTime() {
        return time;
    }
    public char getType() {
        return type;
    }
}
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        
        ArrayList<Meet> tmp = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> interval = A.get(i);
            tmp.add(new Meet(interval.get(0),'a'));
            tmp.add(new Meet(interval.get(1),'d'));
        }
        
        Collections.sort(tmp,(x,y)->{
            if(x.getTime() == y.getTime())
                return y.getType()-x.getType();
            return x.getTime()-y.getTime();
        });
        
        int count = 0,res = 1;
        for(Meet m : tmp) {
            if(m.getType() == 'a')
                count++;
            else
                count--;
            if(count > res)
                res = count;
        }
        return res;
    }
}
