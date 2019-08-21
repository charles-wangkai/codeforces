import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] SEGMENT_NUMS = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int a, int b) {
		return IntStream.rangeClosed(a, b).map(x -> String.valueOf(x).chars().map(ch -> SEGMENT_NUMS[ch - '0']).sum())
				.sum();
	}
}
