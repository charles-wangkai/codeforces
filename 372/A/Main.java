import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(int[] s) {
		s = Arrays.stream(s).boxed().sorted().mapToInt(x -> x).toArray();

		int holdNum = -1;
		int lower = 0;
		int upper = s.length / 2;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(s, middle)) {
				holdNum = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return s.length - holdNum;
	}

	static boolean check(int[] s, int holdNum) {
		return IntStream.range(0, holdNum).allMatch(i -> s[i] * 2 <= s[s.length - holdNum + i]);
	}
}
