import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String a = sc.next();

			System.out.println(solve(a));
		}

		sc.close();
	}

	static String solve(String a) {
		int[] evens = a.chars().map(ch -> ch - '0').filter(x -> x % 2 == 0).toArray();
		int[] odds = a.chars().map(ch -> ch - '0').filter(x -> x % 2 != 0).toArray();

		StringBuilder result = new StringBuilder();
		int evenIndex = 0;
		int oddIndex = 0;
		while (evenIndex != evens.length || oddIndex != odds.length) {
			if (oddIndex == odds.length || (evenIndex != evens.length && evens[evenIndex] < odds[oddIndex])) {
				result.append(evens[evenIndex]);
				evenIndex++;
			} else {
				result.append(odds[oddIndex]);
				oddIndex++;
			}
		}

		return result.toString();
	}
}
