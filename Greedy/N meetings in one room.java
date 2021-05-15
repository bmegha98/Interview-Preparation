/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? 
Also note start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
*/

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        if(n == 1)
            return 1;
        
        List<int[]> aux = new ArrayList<>();
        for(int i=0;i<n;i++)
            aux.add(new int[]{start[i],end[i]});
        Collections.sort(aux, (a,b) -> a[1]-b[1]);
        int count = 1,f = aux.get(0)[1];
        
        for(int i=1;i<n;i++) {
            int[] interval = aux.get(i);
            if(interval[0] > f) {
                f = interval[1];
                count++;
            }
        }
        return count;
    }
}
