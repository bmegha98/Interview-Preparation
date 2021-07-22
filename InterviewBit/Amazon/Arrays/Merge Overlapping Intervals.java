/*
Given a collection of intervals, merge all overlapping intervals.
For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//Sort intervals on the basis of start time and merge overlapping ones.
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n = intervals.size();
        if(n < 2)
            return intervals;
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        
        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for(int i=1;i<n;i++) {
            Interval f = res.get(res.size()-1), s = intervals.get(i);
            Interval j;
            if(s.start <= f.end) {
                if(f.end <= s.end) {
                    res.remove(res.size()-1);
                    res.add(new Interval(f.start,s.end));
                    continue;
                }
                else
                    j = f;
            } 
            else
                j = s;
            if(f.start == j.start && f.end == j.end)
                continue;
            res.add(j);
        }
        return res;
    }
}
