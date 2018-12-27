import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] points = new int[n];
		for (int i = 0; i < points.length; i++) {
			points[i] = sc.nextInt();
		}
		System.out.println(solve(points));

		sc.close();
	}

	static int solve(int[] points) {
		int amazingNum = 0;
		int min = points[0];
		int max = points[0];
		for (int i = 1; i < points.length; i++) {
			if (points[i] < min) {
				min = points[i];
				amazingNum++;
			} else if (points[i] > max) {
				max = points[i];
				amazingNum++;
			}
		}
		return amazingNum;
	}
}
