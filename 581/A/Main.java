import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static String solve(int a, int b) {
		return String.format("%d %d", Math.min(a, b), (Math.max(a, b) - Math.min(a, b)) / 2);
	}
}
