import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long n = sc.nextLong();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static long solve(long n) {
		String s = "";
		while (n != 0) {
			s = n % 3 + s;
			n /= 3;
		}

		int twoIndex = s.indexOf('2');
		if (twoIndex >= 0) {
			int zeroIndex = s.substring(0, twoIndex).lastIndexOf('0');
			if (zeroIndex >= 0) {
				s = String.format("%s1%s", s.substring(0, zeroIndex), repeat('0', s.length() - zeroIndex - 1));
			} else {
				s = String.format("1%s", repeat('0', s.length()));
			}
		}

		return Long.parseLong(s, 3);
	}

	static String repeat(char ch, int count) {
		return IntStream.range(0, count).mapToObj(i -> ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
