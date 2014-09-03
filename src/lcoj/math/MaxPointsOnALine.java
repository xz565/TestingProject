package lcoj.math;

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


    public boolean pass(Point point) {

      if (verticalLine) {
        return Math.abs(point.x - intercept) < DELTA;
      } else {
        return Math.abs(point.y - (slope * point.x + intercept)) < DELTA;
      }
    }
  }


  public static void main(String[] args) {

    Point[] points = new Point[4];
    points[0] = new Point(3, 10);
    points[1] = new Point(0, 2);
    points[2] = new Point(0, 2);
    points[3] = new Point(3, 10);

    MaxPointsOnALine m = new MaxPointsOnALine();
    System.out.println(m.maxPointsWorse(points));
  }
}
