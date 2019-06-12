import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		System.out.println(solve(K));

		sc.close();
	}

	static int solve(int K) {
		int[] sequence = new int[K];
		for (int i = 0; i < sequence.length; i++) {
			if (i <= 1) {
				sequence[i] = 1;
			} else {
				sequence[i] = sequence[i - 1] + sequence[i - 2];
			}
		}

		return Arrays.stream(sequence).sum();
	}
}
