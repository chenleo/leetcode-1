/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * http://oj.leetcode.com/problems/merge-intervals/
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
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (intervals.size() == 0) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) { // merge
                int end = Math.max(pre.end, cur.end);
                Interval newInterval = new Interval(pre.start, end);
                pre = newInterval;
            }
            else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre); // **important** don't forget
        return res;
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}