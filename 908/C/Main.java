import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	int r = sc.nextInt();
	int[] x = new int[n];
	for (int i = 0; i < x.length; i++) {
	    x[i] = sc.nextInt();
	}
	System.out.println(solve(x, r));

	sc.close();
    }

    static String solve(int[] x, int r) {
	List<Point> centers = new ArrayList<>();
	for (int xi : x) {
	    double y = r;
	    for (Point center : centers) {
		if (Math.abs(xi - center.x) <= 2 * r) {
		    y = Math.max(y, center.y + Math.sqrt(4 * r * r - (xi - center.x) * (xi - center.x)));
		}
	    }

	    centers.add(new Point(xi, y));
	}

	return centers.stream().map(center -> String.valueOf(center.y)).collect(Collectors.joining(" "));
    }
}

class Point {
    int x;
    double y;

    Point(int x, double y) {
	this.x = x;
	this.y = y;
    }
}