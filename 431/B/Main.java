import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] g = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(g));

		sc.close();
	}

	static int solve(int[][] g) {
		int[] sequence = IntStream.range(0, SIZE).toArray();

		return search(g, sequence, 0);
	}

	static int search(int[][] g, int[] sequence, int index) {
		if (index == sequence.length) {
			int result = 0;
			for (int i = 0; i < sequence.length; i++) {
				for (int j = i; j + 1 < sequence.length; j += 2) {
					result += g[sequence[j]][sequence[j + 1]] + g[sequence[j + 1]][sequence[j]];
				}
			}

			return result;
		}

		int result = -1;
		for (int i = index; i < sequence.length; i++) {
			swap(sequence, i, index);

			result = Math.max(result, search(g, sequence, index + 1));

			swap(sequence, i, index);
		}

		return result;
	}

	static void swap(int[] sequence, int index1, int index2) {
		int temp = sequence[index1];
		sequence[index1] = sequence[index2];
		sequence[index2] = temp;
	}
}
