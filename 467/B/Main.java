import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] x = new int[m + 1];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(n, x, k));

		sc.close();
	}

	static int solve(int n, int[] x, int k) {
		String[] binaries = Arrays.stream(x).mapToObj(xi -> convertToBinary(n, xi)).toArray(String[]::new);
		return (int) Arrays.stream(binaries, 0, binaries.length - 1)
				.filter(player -> isFriend(k, player, binaries[binaries.length - 1])).count();
	}

	static String convertToBinary(int n, int number) {
		String result = Integer.toBinaryString(number);
		while (result.length() < n) {
			result = '0' + result;
		}
		return result;
	}

	static boolean isFriend(int k, String player1, String player2) {
		return IntStream.range(0, player1.length()).filter(i -> player1.charAt(i) != player2.charAt(i)).count() <= k;
	}
}
