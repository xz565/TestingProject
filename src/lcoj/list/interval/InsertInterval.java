package lcoj.list.interval;

import java.util.List;
import java.util.ListIterator;

import lcoj.common.Interval;

// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
public class InsertInterval {

  // An inplace solution
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

    ListIterator<Interval> iter = intervals.listIterator();
    while (iter.hasNext()) {
      Interval curt = iter.next();

      if (newInterval.end < curt.start) {
        iter.previous();
        iter.add(newInterval);
        return intervals;

      } else if (newInterval.start > curt.end) {
        continue;

      } else {
        newInterval.start = Math.min(curt.start, newInterval.start);
        newInterval.end = Math.max(curt.end, newInterval.end);
        iter.remove();
      }
    }

    intervals.add(newInterval);
    return intervals;
  }
}
