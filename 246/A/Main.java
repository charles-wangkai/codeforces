import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		return (n <= 2) ? "-1"
				: IntStream.range(0, n).mapToObj(i -> String.valueOf(n - i)).collect(Collectors.joining(" "));
	}
}
