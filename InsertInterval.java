/**
 * Insert Interval 
 * Given a set of non-overlapping intervals, insert a new interval
 * into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according
 * to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * http://oj.leetcode.com/problems/insert-interval/
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] points = new int[2 * intervals.size()];
        int i = 0;
        for (Interval inter: intervals) {
            points[i++] = inter.start;
            points[i++] = inter.end;
        }
        
        int l = insertIndex(points, newInterval.start);
        int i1 = l / 2;
        if (l % 2 == 1) { // within an interval
            newInterval.start = points[l - 1];
        }
        else if (l > 0 && newInterval.start == points[l - 1]) { // start equal last interval's end
            newInterval.start = points[l - 2];
            i1--;
        }
        
        int r = insertIndex(points, newInterval.end);
        int i2 = (r + 1) / 2 - 1;
        if (r % 2 == 1) {
            newInterval.end = points[r];
        }
        
        for (i = i1; i <= i2; i++) intervals.remove(i1); // **important** indexes change after remove each one
        intervals.add(i1, newInterval);
        return intervals;
        
    }
    
    private int insertIndex (int[] a, int n) {
        
        if (a.length == 0 || a[0] > n) return 0;
        if (a[a.length - 1] <= n) return a.length;
        
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (a[middle] <= n && (middle == a.length - 1 || a[middle + 1] > n)) return middle + 1;
            else if (a[middle] > n) high = middle - 1;
            else low = middle + 1;
        }
        // actually should not reach here
        return -1;
    }
}
