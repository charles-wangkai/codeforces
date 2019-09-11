import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.print(solve(n, m));

		sc.close();
	}

	static String solve(int n, int m) {
		List<String> dances = new ArrayList<>();
		dances.add("1 1");
		for (int i = 2; i <= n; i++) {
			dances.add(String.format("%d 1", i));
		}
		for (int i = 2; i <= m; i++) {
			dances.add(String.format("1 %d", i));
		}

		return String.format("%d\n%s", dances.size(), String.join("\n", dances));
	}
}
