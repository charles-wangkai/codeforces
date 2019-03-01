import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y, x0, y0));

		sc.close();
	}

	static int solve(int[] x, int[] y, int x0, int y0) {
		return (int) IntStream.range(0, x.length).mapToObj(i -> new Slope(x[i] - x0, y[i] - y0)).distinct().count();
	}
}

class Slope {
	int dx;
	int dy;

	Slope(int dx, int dy) {
		if (dx < 0) {
			dx = -dx;
			dy = -dy;
		} else if (dx == 0) {
			dy = Math.abs(dy);
		}

		int g = gcd(dx, dy);
		this.dx = dx / g;
		this.dy = dy / g;
	}

	int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dx, dy);
	}

	@Override
	public boolean equals(Object obj) {
		Slope other = (Slope) obj;
		return dx == other.dx && dy == other.dy;
	}
}