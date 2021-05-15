/*
Given N activities with their start and finish day given in array start[ ] and end[ ]. Select the maximum number of activities that can be performed by a single
person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.
*/

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
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
