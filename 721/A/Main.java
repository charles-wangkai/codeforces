import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String row = sc.next();

		List<Integer> lengths = solve(row);
		System.out.println(lengths.size());
		System.out.println(String.join(" ", lengths.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(String row) {
		List<Integer> lengths = new ArrayList<>();
		int length = 0;
		for (int i = 0; i <= row.length(); i++) {
			if (i < row.length() && row.charAt(i) == 'B') {
				length++;
			} else if (length > 0) {
				lengths.add(length);

				length = 0;
			}
		}
		return lengths;
	}
}
