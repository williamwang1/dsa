import java.util.*;

public class DS_K_closet_points {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> pq = new PriorityQueue(k, new Comparator<Point>() {

            public int compare(Point a, Point b) {
                int diff = getDistance(b, origin) - getDistance(a, origin);
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });

        for (Point point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Point[] res = new Point[k];
        while (!pq.isEmpty()) {
            res[k - 1] = pq.poll();
            k = k - 1;
        }

        return res;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}

/**
 * Inspiration:
 * k closet point --> k smallest distance point -> k size max heap
 *
 * Steps
 * 1. pq -- max heap, sort by distance to origin, x axis, y axis
 * 2. maintain k size max heap
 * 3. handling result, element in priority queue in rever order
 *
 *
 * My solution;
 * matain maxheap -- size k
 * override comparator, sort by distance, x axis, y axis
 */
