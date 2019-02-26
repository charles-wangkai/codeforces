import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<Integer> result = solve(n);
		System.out.println(result.size());
		System.out.println(String.join(" ", result.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(int n) {
		List<Integer> result = new ArrayList<>();
		while (n != 0) {
			int number = Integer.parseInt(String.join("", String.valueOf(n).chars()
					.mapToObj(x -> String.valueOf(Math.min(1, x - '0'))).toArray(String[]::new)));

			result.add(number);
			n -= number;
		}
		return result;
	}
}
