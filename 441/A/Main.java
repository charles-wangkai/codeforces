import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int v = sc.nextInt();
		int[][] s = new int[n][];
		for (int i = 0; i < s.length; i++) {
			int k = sc.nextInt();
			s[i] = new int[k];
			for (int j = 0; j < s[i].length; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		List<Integer> solution = solve(s, v);
		System.out.println(solution.size());
		System.out.println(String.join(" ", solution.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(int[][] s, int v) {
		return IntStream.rangeClosed(1, s.length).filter(i -> Arrays.stream(s[i - 1]).anyMatch(x -> v > x)).boxed()
				.collect(Collectors.toList());
	}
}
