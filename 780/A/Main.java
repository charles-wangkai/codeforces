import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n * 2];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x));

		sc.close();
	}

	static int solve(int[] x) {
		int result = 0;
		Set<Integer> table = new HashSet<>();
		for (int sock : x) {
			if (table.contains(sock)) {
				table.remove(sock);
			} else {
				table.add(sock);

				result = Math.max(result, table.size());
			}
		}
		return result;
	}
}
