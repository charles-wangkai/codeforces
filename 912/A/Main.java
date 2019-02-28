import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println(solve(A, B, x, y, z));

		sc.close();
	}

	static long solve(int A, int B, int x, int y, int z) {
		return Math.max(0, x * 2L + y - A) + Math.max(0, y + z * 3L - B);
	}
}
