import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] numbers = new int[3][3];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(numbers));

		sc.close();
	}

	static int solve(int[][] numbers) {
		return computeMedian(Arrays.stream(numbers).mapToInt(Main::computeMedian).toArray());
	}

	static int computeMedian(int[] triple) {
		return Arrays.stream(triple).sorted().toArray()[1];
	}
}
