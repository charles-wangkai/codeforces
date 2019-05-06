import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] fingers = new int[n];
		for (int i = 0; i < fingers.length; i++) {
			fingers[i] = sc.nextInt();
		}
		System.out.println(solve(fingers));

		sc.close();
	}

	static int solve(int[] fingers) {
		int total = Arrays.stream(fingers).sum();

		return (int) IntStream.rangeClosed(1, 5).filter(x -> (total + x - 1) % (fingers.length + 1) != 0).count();
	}
}
