public class day24 {

    Name Of The Problem :- Merge Intervals
    Day :- 24
    Problem Description
 
 

Given a set of non-overlapping intervals and a new interval.

Insert the new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
Note: Make sure the returned intervals are also sorted.



Problem Constraints
0 <= |intervals| <= 106
1 <= intervalsi.start < intervalsi.end <= 109
1 <= newInterval.start < newInteval.end <= 109


Input Format
The First argument is an array of Intervals.
The second argument is the new Interval.


Output Format
Return the array of merged intervals.


Example Input
Input 1:
Intervals = [[1,3],[6,9]]
newInterval = [2,5]
Input 2:
Intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,9]


Example Output
Output 1:
[[1,5],[6,9]]
Output 2:
[1,2],[3,10],[12,16]


Example Explanation
Explanation 1:
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
Explanation 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


----------------------------------------------------------------------------------------

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
     ArrayList<Interval> result = new ArrayList<>();
    for (int i = 0; i < intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if (interval.end < newInterval.start) {
        result.add(interval);
      } else if (newInterval.end < interval.start) {
        result.add(newInterval);
        result.addAll(intervals.subList(i, intervals.size()));
        return result;
      } else {
        int start = Math.min(newInterval.start, interval.start);
        int end = Math.max(newInterval.end, interval.end);
        newInterval.start = start;
        newInterval.end = end;
      }
    }

    result.add(newInterval);

    return result;

    }
}

    
}
