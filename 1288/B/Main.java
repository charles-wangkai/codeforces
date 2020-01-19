import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			System.out.println(solve(A, B));
		}

		sc.close();
	}

	static long solve(int A, int B) {
		int count = 0;
		for (long b = 9; b <= B; b = b * 10 + 9) {
			++count;
		}

		return (long) A * count;
	}
}
