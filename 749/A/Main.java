import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Integer> solution = solve(n);
		System.out.println(solution.size());
		System.out.println(String.join(" ", solution.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(int n) {
		List<Integer> result = new ArrayList<Integer>();
		while (n != 0) {
			int prime;
			if (n % 2 == 0) {
				prime = 2;
			} else {
				prime = 3;
			}

			result.add(prime);
			n -= prime;
		}
		return result;
	}
}
