package lcoj.math;

import java.util.HashMap;
import java.util.Map;

import lcoj.common.Point;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author Xiaodong Zhang
 * 
 */
public class MaxPointsOnALine {

  // O(N^3) and got accpted by OJ
  public int maxPointsWorse(Point[] points) {

    if (points.length == 1) {
      return 1;
    }

    int max = 0;
    // Map<Line, Integer> countMap = new HashMap<Line, Integer>();

    for (int i = 0 ; i < points.length ; i++) {
      for (int j = i + 1 ; j < points.length ; j++) {

        Line line = new Line(points[i], points[j]);

        int count = 0;
        for (Point point : points) {
          if (line.pass(point)) {
            count++;
          }
        }

        if (count > max) {
          max = count;
        }
      }
    }

    return max;
  }

  private class Line {

    private final double DELTA = 0.0001;
    private double slope;
    private double intercept;
    private boolean verticalLine = false;


    public Line(Point p1, Point p2) {

      if (Math.abs(p1.x - p2.x) < DELTA) {
        verticalLine = true;
        intercept = p1.x;
      } else {
        slope = 1.0 * (p1.y - p2.y) / (p1.x - p2.x);
        intercept = p1.y - slope * p1.x;
      }
    }

    public boolean equals(Object obj) {
    	if(obj != null && obj instanceof Line) {
    		Line line = (Line) obj;
    		if(isEqual(slope, line.slope) && isEqual(intercept, line.intercept) 
    				&& verticalLine == line.verticalLine) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int hashCode() {
    	int s = (int) slope * 1000;
    	int i = (int) intercept * 1000;
    	return s | i;
    }

    private boolean isEqual(double x, double y) {
		return Math.abs(x - y) < DELTA;
	}

	public boolean pass(Point point) {

      if (verticalLine) {
        return Math.abs(point.x - intercept) < DELTA;
      } else {
        return Math.abs(point.y - (slope * point.x + intercept)) < DELTA;
      }
    }
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(verticalLine).append(" ").append(slope).append(" ").append(intercept).append(" ").append(hashCode());
		return sb.toString();
	}
  }

  // OK, this solution failed in one test case, can't find the cause... too bad
  public int maxPointsWrong(Point[] points) {
	  if(points == null || points.length == 0) {
		  return 0;
	  }
	  
	  Line maxLine = null;
	  Map<Line, Integer> countMap = new HashMap<Line, Integer>();
	  for(int i = 0; i < points.length; i++) {
		  for(int j = i + 1; j < points.length; j++) {

				  Line line = new Line(points[i], points[j]);
				  if(countMap.containsKey(line)) {
					  countMap.put(line, countMap.get(line) + 1);
				  } else {
					  countMap.put(line, 1);
				  }
				  
				  if(maxLine == null || countMap.get(line) > countMap.get(maxLine)) {
					  maxLine = line;
				  }
		  }
	  }
	  
	  int max = 1;
	  if(maxLine != null) {
		  for(Point p : points) {
			  if(maxLine.pass(p)) {
				  max++;
			  }
		  }
	  }
	  
	  return max;
  }
  
  // a popular solution on the Internet
  public int maxPoints(Point[] points) {
	  if(points == null || points.length ==0) {
		  return 0;
	  }

	  Map<Double, Integer> map = new HashMap<Double, Integer>();
	  int max = 1;

	  for(int i = 0; i < points.length; i++) {
		  map.clear();
		  int samePosition = 1;
		  for(int j = i + 1; j < points.length; j++) {
			  Point p = points[i];
			  Point q = points[j];
			  if(p.x == q.x && p.y == q.y) {
				  samePosition++;
			  } else {
				  double key = p.x == q.x ? Integer.MAX_VALUE : 0.0 + (double)(p.y - q.y) / (p.x - q.x);
				  if(map.containsKey(key)) {
					  map.put(key, map.get(key) + 1);
				  } else {
					  map.put(key, 1);
				  }
			  }
		  }
		  System.out.println(map);
		  for(int value : map.values()) {
			  if(value + samePosition > max) {
				  max = value + samePosition;
			  }
		  }
	  }
	  return max;
  }
  
  public static void main(String[] args) {

//    Point[] points = new Point[4];
//    points[0] = new Point(0, 0);
//    points[1] = new Point(0, 2);
//    points[2] = new Point(0, 2);
//    points[3] = new Point(3, 10);

//    Point[] points = new Point[]{new Point(84,250),new Point(0,0),new Point(1,0),new Point(0,-70),new Point(0,-70),new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
    Point[] points = new Point[]{new Point(2,3),new Point(3,3),new Point(-5,3)};
    MaxPointsOnALine m = new MaxPointsOnALine();
    System.out.println(m.maxPoints(points));
  }
}
