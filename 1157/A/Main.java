import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		Set<Integer> history = new HashSet<>();
		while (!history.contains(n)) {
			history.add(n);
			n = f(n);
		}
		return history.size();
	}

	static int f(int x) {
		int result = x + 1;
		while (result % 10 == 0) {
			result /= 10;
		}
		return result;
	}
}
