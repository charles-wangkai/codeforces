import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}
		System.out.println(solve(matrix));

		sc.close();
	}

	static int solve(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int max = Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).max().getAsInt()).max().getAsInt();
		List<Integer> primes = buildPrimes(max);

		int[][] moveNums = IntStream.range(0, n)
				.mapToObj(r -> IntStream.range(0, m).map(c -> computeMoveNum(primes, matrix[r][c])).toArray())
				.toArray(int[][]::new);

		int[] rowSums = IntStream.range(0, n).map(r -> Arrays.stream(moveNums[r]).sum()).toArray();
		int[] colSums = IntStream.range(0, m).map(c -> IntStream.range(0, n).map(r -> moveNums[r][c]).sum()).toArray();

		return Math.min(Arrays.stream(rowSums).min().getAsInt(), Arrays.stream(colSums).min().getAsInt());
	}

	static List<Integer> buildPrimes(int max) {
		List<Integer> primes = new ArrayList<>();

		for (int i = 2;; i++) {
			if (isPrime(primes, i)) {
				primes.add(i);

				if (i >= max) {
					return primes;
				}
			}
		}
	}

	static boolean isPrime(List<Integer> primes, int x) {
		for (int prime : primes) {
			if (x % prime == 0) {
				return false;
			}
		}

		return true;
	}

	static int computeMoveNum(List<Integer> primes, int x) {
		int index = Collections.binarySearch(primes, x);
		if (index >= 0) {
			return 0;
		} else {
			return primes.get(-1 - index) - x;
		}
	}
}
