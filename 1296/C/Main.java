import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String path = sc.next();

            System.out.println(solve(path));
        }

        sc.close();
    }

    static String solve(String path) {
        int l = -1;
        int r = -1;

        int x = 0;
        int y = 0;
        Map<Point, Integer> pointToPos = new HashMap<>();
        pointToPos.put(new Point(0, 0), 0);

        for (int i = 0; i < path.length(); ++i) {
            char move = path.charAt(i);
            if (move == 'L') {
                --x;
            } else if (move == 'R') {
                ++x;
            } else if (move == 'U') {
                ++y;
            } else {
                --y;
            }

            Point point = new Point(x, y);
            if (pointToPos.containsKey(point) && (l == -1 || i - pointToPos.get(point) < r - l)) {
                l = pointToPos.get(point) + 1;
                r = i + 1;
            }

            pointToPos.put(point, i + 1);
        }

        return (l == -1) ? "-1" : String.format("%d %d", l, r);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }
}