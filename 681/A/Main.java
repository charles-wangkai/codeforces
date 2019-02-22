import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Result[] results = new Result[n];
		for (int i = 0; i < results.length; i++) {
			String name = sc.next();
			int before = sc.nextInt();
			int after = sc.nextInt();

			results[i] = new Result(name, before, after);
		}
		System.out.println(solve(results) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(Result[] results) {
		return Arrays.stream(results).anyMatch(result -> result.before >= 2400 && result.after > result.before);
	}
}

class Result {
	String name;
	int before;
	int after;

	Result(String name, int before, int after) {
		this.name = name;
		this.before = before;
		this.after = after;
	}
}