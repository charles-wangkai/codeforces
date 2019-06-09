import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String a = sc.next();
		int[] f = new int[10];
		for (int i = 1; i < f.length; i++) {
			f[i] = sc.nextInt();
		}
		System.out.println(solve(a, f));

		sc.close();
	}

	static String solve(String a, int[] f) {
		int[] digits = a.chars().map(ch -> ch - '0').toArray();

		int beginIndex = 0;
		while (beginIndex < digits.length && f[digits[beginIndex]] <= digits[beginIndex]) {
			beginIndex++;
		}

		for (int i = beginIndex; i < digits.length && f[digits[i]] >= digits[i]; i++) {
			digits[i] = f[digits[i]];
		}

		return Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining());
	}
}
