import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(solve(A, B));

		sc.close();
	}

	static int solve(int A, int B) {
		return IntStream.rangeClosed(1, Math.min(A, B)).reduce((x, y) -> x * y).getAsInt();
	}
}
