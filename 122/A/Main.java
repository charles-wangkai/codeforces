import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n) {
		return IntStream.rangeClosed(1, n).anyMatch(x -> n % x == 0 && isLucky(x));
	}

	static boolean isLucky(int x) {
		return String.valueOf(x).chars().allMatch(ch -> ch == '4' || ch == '7');
	}
}
