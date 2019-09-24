import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] elements = new int[n];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = sc.nextInt();
		}
		System.out.println(solve(elements));

		sc.close();
	}

	static String solve(int[] elements) {
		int[] counts = new int[8];
		for (int element : elements) {
			counts[element]++;
		}

		if (!(counts[1] * 3 == elements.length && counts[7] == 0 && counts[5] == 0 && counts[2] >= counts[4]
				&& counts[2] - counts[4] + counts[3] == counts[6])) {
			return "-1";
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < counts[4]; i++) {
			result.add("1 2 4");
		}
		for (int i = 0; i < counts[2] - counts[4]; i++) {
			result.add("1 2 6");
		}
		for (int i = 0; i < counts[3]; i++) {
			result.add("1 3 6");
		}

		return String.join("\n", result);
	}
}
