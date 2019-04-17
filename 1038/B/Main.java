import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n <= 2) {
			return "No";
		}

		int alone = (n + 1) / 2;
		return String.format("Yes\n%s\n%s", buildOutput(new int[] { alone }),
				buildOutput(IntStream.rangeClosed(1, n).filter(x -> x != alone).toArray()));
	}

	static String buildOutput(int[] a) {
		return String.format("%d %s", a.length,
				Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
