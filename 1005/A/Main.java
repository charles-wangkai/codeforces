import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		List<Integer> stairways = solve(a);
		System.out.println(stairways.size());
		System.out.println(String.join(" ", stairways.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(int[] a) {
		return Stream.concat(IntStream.range(0, a.length - 1).filter(i -> a[i] >= a[i + 1]).map(i -> a[i]).boxed(),
				Stream.of(a[a.length - 1])).collect(Collectors.toList());
	}
}
