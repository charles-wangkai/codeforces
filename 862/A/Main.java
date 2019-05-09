import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		System.out.println(solve(set, x));

		sc.close();
	}

	static int solve(Set<Integer> set, int x) {
		return (int) IntStream.range(0, x).filter(p -> !set.contains(p)).count() + (set.contains(x) ? 1 : 0);
	}
}
