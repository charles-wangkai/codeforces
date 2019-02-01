import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		System.out.println(solve(s, v1, v2, t1, t2));

		sc.close();
	}

	static String solve(int s, int v1, int v2, int t1, int t2) {
		int time1 = computeTime(s, v1, t1);
		int time2 = computeTime(s, v2, t2);

		if (time1 < time2) {
			return "First";
		} else if (time1 > time2) {
			return "Second";
		} else {
			return "Friendship";
		}
	}

	static int computeTime(int s, int v, int t) {
		return s * v + t * 2;
	}
}
