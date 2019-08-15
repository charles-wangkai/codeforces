import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] sequence = new int[n];
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = sc.nextInt();
		}
		System.out.println(solve(sequence));

		sc.close();
	}

	static String solve(int[] sequence) {
		int min = Arrays.stream(sequence).min().getAsInt();
		OptionalInt result = Arrays.stream(sequence).filter(x -> x != min).min();

		return result.isPresent() ? String.valueOf(result.getAsInt()) : "NO";
	}
}
