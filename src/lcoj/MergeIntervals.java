package lcoj;

import java.util.ArrayList;

import lcoj.common.Interval;

public class MergeIntervals {

    // Accepted solution, but need to think about the complexity (TODO)
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

	while (hasOverlap(intervals)) {
	    intervals = merge2(intervals);
	}

	return intervals;
    }

    private boolean hasOverlap(ArrayList<Interval> intervals) {

	for (Interval interval : intervals) {
	    for (Interval interval2 : intervals) {
		if (interval != interval2 && isOverlap(interval, interval2)) {
		    return true;
		}
	    }
	}
	return false;
    }

    public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {

	ArrayList<Interval> result = new ArrayList<Interval>();

	for (Interval newInterval : intervals) {

	    boolean isNew = true;

	    for (Interval existingInterval : result) {

		if (isOverlap(newInterval, existingInterval)) {
		    existingInterval.start = (existingInterval.start < newInterval.start ? existingInterval.start
			    : newInterval.start);
		    existingInterval.end = (existingInterval.end > newInterval.end ? existingInterval.end
			    : newInterval.end);

		    isNew = false;
		    break;
		}

	    }

	    if (isNew) {
		Interval inteval = new Interval(newInterval.start,
			newInterval.end);
		result.add(inteval);
	    }
	}

	return result;
    }

    private boolean isOverlap(Interval newInternval, Interval exisInterval) {
	return isOverlapHelper(newInternval, exisInterval)
		|| isOverlapHelper(exisInterval, newInternval);
    }

    private boolean isOverlapHelper(Interval i1, Interval i2) {

	return (i1.start >= i2.start && i1.start <= i2.end)
		|| (i1.end >= i2.start && i1.end <= i2.end);
    }

}
