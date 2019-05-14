import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] grades = new int[n];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = sc.nextInt();
		}
		System.out.println(solve(grades));

		sc.close();
	}

	static int solve(int[] grades) {
		Arrays.sort(grades);

		int sum = Arrays.stream(grades).sum();
		int result = 0;
		while (2 * sum < 9 * grades.length) {
			sum += 5 - grades[result];
			result++;
		}
		return result;
	}
}
