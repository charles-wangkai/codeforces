import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		String[] phones = new String[N];
		for (int i = 0; i < phones.length; i++) {
			phones[i] = sc.next();
		}
		System.out.println(solve(K, phones));

		sc.close();
	}

	static int solve(int K, String[] phones) {
		Map<Character, Integer> firstDigitToCount = new HashMap<>();
		for (String phone : phones) {
			char firstDigit = phone.charAt(0);

			firstDigitToCount.put(firstDigit, firstDigitToCount.getOrDefault(firstDigit, 0) + 1);
		}

		return 2 + firstDigitToCount.values().stream().mapToInt(count -> divideToCeil(count, K)).sum();
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
