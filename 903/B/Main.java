import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h1 = sc.nextInt();
		int a1 = sc.nextInt();
		int c1 = sc.nextInt();
		int h2 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.print(solve(h1, a1, c1, h2, a2));

		sc.close();
	}

	static String solve(int h1, int a1, int c1, int h2, int a2) {
		int strikeNum = divideToCeil(h2, a1);
		int healNum = divideToCeil(Math.max(0, (strikeNum - 1) * a2 + 1 - h1), c1 - a2);

		List<String> phases = Stream.concat(IntStream.range(0, healNum).mapToObj(i -> "HEAL"),
				IntStream.range(0, strikeNum).mapToObj(i -> "STRIKE")).collect(Collectors.toList());

		return String.format("%d\n%s", phases.size(), String.join("\n", phases));
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
