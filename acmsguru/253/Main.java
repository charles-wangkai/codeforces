import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Point[] convexPolygon = new Point[N];
    for (int i = 0; i < convexPolygon.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      convexPolygon[i] = new Point(x, y);
    }
    Point[] points = new Point[M];
    for (int i = 0; i < points.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      points[i] = new Point(x, y);
    }
    System.out.println(solve(convexPolygon, points, K) ? "YES" : "NO");
  }

  static boolean solve(Point[] convexPolygon, Point[] points, int K) {
    Stream.concat(Arrays.stream(convexPolygon), Arrays.stream(points))
        .forEach(
            p -> {
              p.x *= 3;
              p.y *= 3;
            });

    Point z =
        new Point(
            (convexPolygon[0].x + convexPolygon[1].x + convexPolygon[2].x) / 3,
            (convexPolygon[0].y + convexPolygon[1].y + convexPolygon[2].y) / 3);

    Element[] elements =
        IntStream.range(0, convexPolygon.length)
            .mapToObj(i -> new Element(i, computeAngle(z, convexPolygon[i])))
            .sorted(Comparator.comparing(Element::angle))
            .toArray(Element[]::new);

    return Arrays.stream(points)
            .filter(
                point -> {
                  int beginIndex = findBeginIndex(elements, computeAngle(z, point));

                  return computeCrossProduct(
                              convexPolygon[beginIndex],
                              convexPolygon[(beginIndex + 1) % convexPolygon.length],
                              point)
                          .compareTo(BigInteger.ZERO)
                      >= 0;
                })
            .count()
        >= K;
  }

  static BigInteger computeCrossProduct(Point o, Point a, Point b) {
    return BigInteger.valueOf(a.x - o.x)
        .multiply(BigInteger.valueOf(b.y - o.y))
        .subtract(BigInteger.valueOf(b.x - o.x).multiply(BigInteger.valueOf(a.y - o.y)));
  }

  static double computeAngle(Point o, Point p) {
    return Math.atan2(p.y - o.y, p.x - o.x);
  }

  static int findBeginIndex(Element[] elements, double angle) {
    if (angle < elements[0].angle()) {
      return elements[elements.length - 1].index();
    }

    int result = -1;
    int lower = 0;
    int upper = elements.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      if (elements[middle].angle() <= angle) {
        result = elements[middle].index();
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}

class Point {
  long x;
  long y;

  Point(long x, long y) {
    this.x = x;
    this.y = y;
  }
}

record Element(int index, double angle) {}
