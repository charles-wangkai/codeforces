import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(solve(numbers));

		sc.close();
	}

	static int solve(int[] numbers) {
		int[] oddIndices = IntStream.range(0, numbers.length).filter(i -> numbers[i] % 2 != 0).toArray();
		int[] evenIndices = IntStream.range(0, numbers.length).filter(i -> numbers[i] % 2 == 0).toArray();

		if (oddIndices.length == 1) {
			return oddIndices[0] + 1;
		} else {
			return evenIndices[0] + 1;
		}
	}
}
