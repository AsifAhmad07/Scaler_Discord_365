import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class day25 {

    Name Of The Problem :- Merge Overlapping Intervals
    Date :- 26-jan-2024


    Problem Description
 
 

Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.


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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
      public int compare(Interval i1, Interval i2) {
        int c = i1.start - i2.start;
        if (c != 0) {
          return c;
        }
        return i1.end - i2.end;
      }
    });
    int idx = 0;
    int n = intervals.size();
    ArrayList<Interval> result = new ArrayList<>();
    while (idx < n) {
      Interval currInterval = intervals.get(idx);
      int currEnd = currInterval.end;
      while (idx < n && intervals.get(idx).start <= currEnd) {
        currEnd = Math.max(intervals.get(idx++).end, currEnd);
      }
      result.add(new Interval(currInterval.start, currEnd));
    }
    return result;

    }
}

    
}
