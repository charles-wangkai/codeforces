import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = sc.nextInt();
		}
		System.out.println(solve(id, k));

		sc.close();
	}

	static String solve(int[] id, int k) {
		List<Integer> displayed = new ArrayList<>();
		for (int x : id) {
			if (!displayed.contains(x)) {
				if (displayed.size() == k) {
					displayed.remove(k - 1);
				}

				displayed.add(0, x);
			}
		}

		return String.format("%d\n%s", displayed.size(),
				displayed.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
